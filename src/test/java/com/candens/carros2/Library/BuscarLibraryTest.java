package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
class BuscarLibraryTest {
    public BuscarLibraryTest() {
    }
        @Test
        public void gettieLibreria () throws SQLException {
            Conexion mockConexionInstancia = mock(Conexion.class); // PRIMER CLON DECÑLADRADO
            Connection mockConnectionReal = mock(Connection.class); // SEGUNDO CLON DECLARADO
            PreparedStatement mockPreparedStatement = mock(PreparedStatement.class); // RTERCER CLON DELCARADO
            ResultSet mockResultSet = mock(ResultSet.class); //CUATO CLON DECLARADO PARA EL rs

            //Programamos el comportamiento en cadena de la base de datos
            when(mockConexionInstancia.getConnection()).thenReturn(mockConnectionReal); // PRIMER CLON USADO
            when(mockConnectionReal.prepareStatement(anyString())).thenReturn(mockPreparedStatement); // SEGUNDO CLON USADO

            // Simulamos que el query afectó a 1 fila (para que no lance el RuntimeException)
            when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet); // CUARTO CLON USADO

            //LA ENTRENADERA DEL rs
            when(mockResultSet.next()).thenReturn(true);
            when(mockResultSet.getInt("id")).thenReturn(7);
            when(mockResultSet.getString("marca")).thenReturn("Sunray");
            when(mockResultSet.getInt("numero_ruedas")).thenReturn(4);
            when(mockResultSet.getString("tipo_transmision")).thenReturn("Mecánica");

            // Congelamos el método estático Conexion.conectar()
            try (MockedStatic<Conexion> conexionEstatica = mockStatic(Conexion.class)) { // APARTIR DE ACA SE ACTIVA EL INTERCEPTOR DE MEMORIA RAM SOBRE Conexion

                // Le decimos: Cuando el código llame a Conexion.conectar(), devuelve nuestro clon
                conexionEstatica.when(Conexion::conectar).thenReturn(mockConexionInstancia); // PREIMER CLON USADO

                //Ejecutamos  clase original sin haberle cambiado nada
                BuscarLibrary library = new BuscarLibrary(); // CREAMOS LA INSTANCIA REAL
                CarroDto dtoPrueba = new CarroDto(7, "Sunray", 4, "Mecánica");
                Integer idecito = 7;

                CarroDto resultado = library.ejecutar(idecito);

                //Verificamos que este lindo
                assertEquals(Integer.valueOf(7), resultado.getId());
                assertEquals("Sunray", resultado.getMarca());

                System.out.println("¡SI LEES ESTO ES PORQ TODO ESTA OKIs");
            } // A PARTIR DE ACA JAVA DESTRUYE EL INTERCEPTOR DE MEMORIA , SE DESARME DESVIOS ESTATICOS Y CONEXION RECUPERA  SU COMPORTAMIENTO NORMAL
        }
    }
