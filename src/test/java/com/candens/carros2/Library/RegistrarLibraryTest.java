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
class RegistrarLibraryTest {
    @Test
    public void posttieLibreria() throws SQLException{
        Conexion mockConexionInstancia = mock(Conexion.class); // PRIMER CLON DECÑLADRADO
        Connection mockConnectionReal = mock(Connection.class); // SEGUNDO CLON DECLARADO
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class); // RTERCER CLON DELCARADO
        ResultSet mockResultSet = mock(ResultSet.class); //CUATO CLON DECLARADO PARA EL rs

        //Programamos el comportamiento en cadena de la base de datos
        when(mockConexionInstancia.getConnection()).thenReturn(mockConnectionReal); // PRIMER CLON USADO
        when(mockConnectionReal.prepareStatement(anyString())).thenReturn(mockPreparedStatement); // SEGUNDO CLON USADO

        // Simulamos que el query afectó a 1 fila (para que no lance el RuntimeException)
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // TERCER CLON USADO
        when(mockPreparedStatement.getGeneratedKeys()).thenReturn(mockResultSet); // CUARTO CLON USADO

        //LA ENTRENADERA DEL rs
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(7);

        // Congelamos el método estático Conexion.conectar()
        try (MockedStatic<Conexion> conexionEstatica = mockStatic(Conexion.class)) { // APARTIR DE ACA SE ACTIVA EL INTERCEPTOR DE MEMORIA RAM SOBRE Conexion

            // Le decimos: Cuando el código llame a Conexion.conectar(), devuelve nuestro clon
            conexionEstatica.when(Conexion::conectar).thenReturn(mockConexionInstancia); // PREIMER CLON USADO

            //Ejecutamos  clase original sin haberle cambiado nada
            RegistrarLibrary library = new RegistrarLibrary(); // CREAMOS LA INSTANCIA REAL
            CarroDto dtoPrueba = new CarroDto(7, "Sunray", 4, "Mecánica");

            CarroDto resultado = library.ejecutar(dtoPrueba);

            //Verificamos que este lindo
            assertEquals(Integer.valueOf(7), resultado.getId());
            assertEquals("Sunray", resultado.getMarca());

            System.out.println("¡SI LEES ESTO ES PORQ TODO ESTA OKIs");
        } // A PARTIR DE ACA JAVA DESTRUYE EL INTERCEPTOR DE MEMORIA , SE DESARME DESVIOS ESTATICOS Y CONEXION RECUPERA  SU COMPORTAMIENTO NORMAL
    }
}