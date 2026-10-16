package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
class RegistrarLibraryTest {
    @Test
    public void posttieLibreria() throws SQLException{
        Conexion mockStaticOut = mock(Conexion.class, RETURNS_DEEP_STUBS); //
        ResultSet mockResultSet = mock(ResultSet.class); //CUATO CLON DECLARADO PARA EL rs

        when(mockStaticOut.getConnection().prepareStatement(anyString()).executeUpdate()).thenReturn(1);
        when(mockStaticOut.getConnection().prepareStatement(anyString()).getGeneratedKeys()).thenReturn(mockResultSet); //TENER EN CUENTA

        //LA ENTRENADERA DEL rs
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(7);

        // Congelamos el método estático Conexion.conectar()
        try (MockedStatic<Conexion> conexionEstatica = mockStatic(Conexion.class)) { // APARTIR DE ACA SE ACTIVA EL INTERCEPTOR DE MEMORIA RAM SOBRE Conexion
            // Le decimos: Cuando el código llame a Conexion.conectar(), devuelve nuestro clon
            conexionEstatica.when(Conexion::conectar).thenReturn(mockStaticOut); // PREIMER CLON USADO

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