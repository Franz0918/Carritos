package com.candens.carros2.Library;


import com.candens.carros2.Library.Conexion.Conexion;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DaoBorrarLibraryTest {
    @Test
    public void deletieLibreria() throws SQLException {
        Conexion mockStaticOut = mock(Conexion.class, RETURNS_DEEP_STUBS); //
        //Programamos el comportamiento en cadena de la base de datos
        when(mockStaticOut.getConnection().prepareStatement(anyString()).executeUpdate()).thenReturn(1);


        // Congelamos el método estático Conexion.conectar()
        try (MockedStatic<Conexion> conexionEstatica = mockStatic(Conexion.class)) { // APARTIR DE ACA SE ACTIVA EL INTERCEPTOR DE MEMORIA RAM SOBRE Conexion
            // Le decimos: Cuando el código llame a Conexion.conectar(), devuelve nuestro clon
            conexionEstatica.when(Conexion::conectar).thenReturn(mockStaticOut); // PREIMER CLON USADO

            //Ejecutamos  clase original sin haberle cambiado nada
            DaoBorrarLibrary bol = new DaoBorrarLibrary(); // CREAMOS LA INSTANCIA REAL
            bol.daoBorrar("sss",77);

            //Verificamos que este lindo
            verify(mockStaticOut.getConnection().prepareStatement(anyString()), times(1)).executeUpdate();

            System.out.println("¡SI LEES ESTO ES PORQ TODO ESTA OKIs");
        } // A PARTIR DE ACA JAVA DESTRUYE EL INTERCEPTOR DE MEMORIA , SE DESARME DESVIOS ESTATICOS Y CONEXION RECUPERA  SU COMPORTAMIENTO NORMAL
    }

}
