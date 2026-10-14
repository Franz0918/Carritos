package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ActualizarLibraryTest {

    @Test
    public void puttieLibreria() throws SQLException {
        Conexion mockConexionInstancia = mock(Conexion.class); // PRIMER CLON DECÑLADRADO
        Connection mockConnectionReal = mock(Connection.class); // SEGUNDO CLON DECLARADO
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class); // RTERCER CLON DELCARADO

        //Programamos el comportamiento en cadena de la base de datos
        when(mockConexionInstancia.getConnection()).thenReturn(mockConnectionReal); // SEGUNDO CLON USADO
        when(mockConnectionReal.prepareStatement(anyString())).thenReturn(mockPreparedStatement); // TERCER CLON USADO

        // Simulamos que el query afectó a 1 fila (para que no lance el RuntimeException)
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // TERCER CLON USADO

        // Congelamos el método estático Conexion.conectar()
        try (MockedStatic<Conexion> conexionEstatica = mockStatic(Conexion.class)) { // APARTIR DE ACA SE ACTIVA EL INTERCEPTOR DE MEMORIA RAM SOBRE Conexion

            // Le decimos: Cuando el código llame a Conexion.conectar(), devuelve nuestro clon
            conexionEstatica.when(Conexion::conectar).thenReturn(mockConexionInstancia); // PREIMER CLON

            //Ejecutamos  clase original sin haberle cambiado nada
            ActualizarLibrary library = new ActualizarLibrary(); // CREAMOS LA INSTANCIA REAL
            CarroDto dtoPrueba = new CarroDto(null, "Sunray", 4, "Mecánica");

            CarroDto resultado = library.ejecutar(7, dtoPrueba);

            //Verificamos que este lindo
            assertEquals(Integer.valueOf(7), resultado.getId());
            assertEquals("Sunray", resultado.getMarca());

            System.out.println("¡SI LEES ESTO ES PORQ TODO ESTA OKIs");
        } // A PARTIR DE ACA JAVA DESTRUYE EL INTERCEPTOR DE MEMORIA , SE DESARME DESVIOS ESTATICOS Y CONEXION RECUPERA  SU COMPORTAMIENTO NORMAL
    }
}