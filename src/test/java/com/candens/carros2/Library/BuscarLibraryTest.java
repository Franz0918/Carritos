package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
class BuscarLibraryTest {

    @Test
    public void gettieLibreria() throws SQLException {
        Conexion mockStaticOut = mock(Conexion.class, Mockito.RETURNS_DEEP_STUBS); // PRIMER CLON DECÑLADRADO con RETURN DEEP STUBS
        ResultSet mockResultSet = mock(ResultSet.class); //CUATO CLON DECLARADO PARA EL rs

        // Simulamos que el query afectó a 1 fila (para que no lance el RuntimeException)
        when(mockStaticOut.getConnection().prepareStatement(anyString()).executeQuery()).thenReturn(mockResultSet);

        //LA ENTRENADERA DEL rs
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt("id")).thenReturn(7);
        when(mockResultSet.getString("marca")).thenReturn("Sunray");
        when(mockResultSet.getInt("numero_ruedas")).thenReturn(4);
        when(mockResultSet.getString("tipo_transmision")).thenReturn("Mecánica");
        // Congelamos el método estático Conexion.conectar()
        try (MockedStatic<Conexion> mockedStatic = mockStatic(Conexion.class)) { // APARTIR DE ACA SE ACTIVA EL INTERCEPTOR DE MEMORIA RAM SOBRE Conexion
            // Le decimos: Cuando el código llame a Conexion.conectar(), devuelve nuestro clon
            mockedStatic.when(Conexion::conectar).thenReturn(mockStaticOut); // PREIMER CLON USADO, mockedStatic solo puede modificar el comportamiento de Conexion.conectar()

            //Ejecutamos  clase original sin haberle cambiado nada
            BuscarLibrary bl = new BuscarLibrary(); // CREAMOS LA INSTANCIA REAL y BORRAMOS: Integer idecito = 7;
            CarroDto resultado = bl.ejecutar(7);

            //Verificamos que este lindo
            assertEquals(Integer.valueOf(7), resultado.getId());
            assertEquals("Sunray", resultado.getMarca());
            System.out.println("¡SI LEES ESTO ES PORQ TODO ESTA OKIs");
        } // A PARTIR DE ACA JAVA DESTRUYE EL INTERCEPTOR DE MEMORIA , SE DESARME DESVIOS ESTATICOS Y CONEXION RECUPERA  SU COMPORTAMIENTO NORMAL
    }

}

 /*
    @Mock
PreparedStatement ps;

@InjectMocks
BuscarLibrary bl;

    @Test
    public void probarLibreriaBuscar() throws SQLException {
        MockedStatic<Conexion> mockedStatic = Mockito.mockStatic(Conexion.class);
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
            try  {

                ResultSet mockResultSet = mock(ResultSet.class);
                mockedStatic.when(() -> Conexion.conectar().getConnection().prepareStatement(anyString())).thenReturn(new Object());
                when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet); // CUARTO CLON USADO

                //LA ENTRENADERA DEL rs
                when(mockResultSet.next()).thenReturn(true);
                when(mockResultSet.getInt("id")).thenReturn(7);
                when(mockResultSet.getString("marca")).thenReturn("SunrayXd");
                when(mockResultSet.getInt("numero_ruedas")).thenReturn(4);
                when(mockResultSet.getString("tipo_transmision")).thenReturn("Mecánica");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            CarroDto prueba = bl.ejecutar(3);
            verify(mockPreparedStatement).executeQuery();
            assertEquals(Integer.valueOf(77), prueba.getId());
            assertEquals("SunrayXd", prueba.getMarca());
    }
    */