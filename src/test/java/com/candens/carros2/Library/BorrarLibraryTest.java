package com.candens.carros2.Library;


import com.candens.carros2.Library.Conexion.Conexion;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class BorrarLibraryTest {
    @Test
    public void deletieLibreria() throws SQLException{
        Conexion mockConexionInstancia = mock(Conexion.class); // PRIMER CLON DECÑLADRADO
        Connection mockConnectionReal = mock(Connection.class); // SEGUNDO CLON DECLARADO
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class); // RTERCER CLON DELCARADO

        //Programamos el comportamiento en cadena de la base de datos
        when(mockConexionInstancia.getConnection()).thenReturn(mockConnectionReal); // PRIMER CLON USADO
        when(mockConnectionReal.prepareStatement(anyString())).thenReturn(mockPreparedStatement); // SEGUNDO CLON USADO

        // Simulamos que el query afectó a 1 fila (para que no lance el RuntimeException)
       when(mockPreparedStatement.executeUpdate()).thenReturn(1); //

        // Congelamos el método estático Conexion.conectar()
        try (MockedStatic<Conexion> conexionEstatica = mockStatic(Conexion.class)) { // APARTIR DE ACA SE ACTIVA EL INTERCEPTOR DE MEMORIA RAM SOBRE Conexion

            // Le decimos: Cuando el código llame a Conexion.conectar(), devuelve nuestro clon
            conexionEstatica.when(Conexion::conectar).thenReturn(mockConexionInstancia); // PREIMER CLON USADO

            //Ejecutamos  clase original sin haberle cambiado nada
            BorrarLibrary library = new BorrarLibrary(); // CREAMOS LA INSTANCIA REAL
            Integer idecito = 7;
            library.ejecutar(idecito);

            //Verificamos que este lindo
            verify(mockPreparedStatement, times(1)).executeUpdate();

            System.out.println("¡SI LEES ESTO ES PORQ TODO ESTA OKIs");
        } // A PARTIR DE ACA JAVA DESTRUYE EL INTERCEPTOR DE MEMORIA , SE DESARME DESVIOS ESTATICOS Y CONEXION RECUPERA  SU COMPORTAMIENTO NORMAL
    }
}