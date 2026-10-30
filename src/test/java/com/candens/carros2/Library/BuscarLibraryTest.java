package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class BuscarLibraryTest {
    @Mock // <-- Fabrica el clon del DAO automáticamente
    private DaoBuscarLibrary daoBuscarMock;

    @InjectMocks // <-- Crea la instancia real e intenta meter los @Mock adentro
    private BuscarLibrary buscarLibrary;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); //  inicializa los mocks antes de cada test
    }

    @Test
    public void buscarLibPrueba() {
        CarroDto carroFalso = new CarroDto(77, "Sunray", 4, "Mecánica");

        //ENTRENANDO AL MOCK
        when(daoBuscarMock.daoBuscar(anyString(), anyInt())).thenReturn(carroFalso);
        CarroDto resultado = buscarLibrary.ejecutar(7);

        assertNotNull(resultado);
        assertEquals(Integer.valueOf(77), resultado.getId());
        assertEquals("Sunray", resultado.getMarca());
        System.out.println("¡YA CASI PRO!");
    }
    @Test
    public void buscarLibPruebaFail() {
        CarroDto carroFalso = new CarroDto(77, "Sunray", 4, "Mecánica");

        //ENTRENANDO AL MOCK
        when(daoBuscarMock.daoBuscar(anyString(), anyInt())).thenReturn(carroFalso);
        CarroDto resultado = buscarLibrary.ejecutar(7);

        assertNotNull(resultado);
        assertEquals(Integer.valueOf(7), resultado.getId());
        assertEquals("Sunray", resultado.getMarca());
        System.out.println("¡DEBERIA FALLAR YA QUE ES OTRO NUMERO!");
    }
}