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

class ListarLibraryTest {
    @Test
    public void listieLibreria() throws SQLException {
        Conexion mockStaticOut = mock(Conexion.class, RETURNS_DEEP_STUBS); //
        ResultSet mockResultSet = mock(ResultSet.class); //CUATO CLON DECLARADO PARA EL rs

        //Programamos el comportamiento en cadena de la base de datos
        when(mockStaticOut.getConnection().prepareStatement(anyString()).executeQuery()).thenReturn(mockResultSet);

        //LA ENTRENADERA DEL rs
        when(mockResultSet.next()).thenReturn(true, false);
        when(mockResultSet.getInt("id")).thenReturn(7);
        when(mockResultSet.getString("marca")).thenReturn("Sunray");
        when(mockResultSet.getInt("numero_ruedas")).thenReturn(4);
        when(mockResultSet.getString("tipo_transmision")).thenReturn("Mecánica");

        // Congelamos el método estático Conexion.conectar()
        try (MockedStatic<Conexion> conexionEstatica = mockStatic(Conexion.class)) { // APARTIR DE ACA SE ACTIVA EL INTERCEPTOR DE MEMORIA RAM SOBRE Conexion
            // Le decimos: Cuando el código llame a Conexion.conectar(), devuelve nuestro clon
            conexionEstatica.when(Conexion::conectar).thenReturn(mockStaticOut); // PREIMER CLON USADO
            //Ejecutamos  clase original sin haberle cambiado nada
            ListarLibrary library = new ListarLibrary(); // CREAMOS LA INSTANCIA REAL
            java.util.List<CarroDto> resultado = library.ejecutar();
            //Verificamos que este lindo
            assertEquals(1, resultado.size()); // Validando que la lista solo tengo un carrodto
            assertEquals(Integer.valueOf(7), resultado.get(0).getId());
            assertEquals("Sunray", resultado.get(0).getMarca());

            System.out.println("¡SI LEES ESTO ES PORQ TAS CASI PRO");
        } // A PARTIR DE ACA JAVA DESTRUYE EL INTERCEPTOR DE MEMORIA , SE DESARME DESVIOS ESTATICOS Y CONEXION RECUPERA  SU COMPORTAMIENTO NORMAL
    }
}