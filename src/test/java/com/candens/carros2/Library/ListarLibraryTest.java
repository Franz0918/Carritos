package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class ListarLibraryTest {
    @Mock // <-- Fabrica el clon del DAO automáticamente
    private DaoListarLibrary daoListarMock;

    @InjectMocks // <-- Crea la instancia real e intenta meter los @Mock adentro
    private ListarLibrary listarLibrary;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); //  inicializa los mocks antes de cada test
    }

    @Test
    public void listarLibPrueba() {

        List<CarroDto> lista = listarLibrary.ejecutar();
        lista.add(new CarroDto(77, "Sunray", 4, "Mecánica"));
        when(daoListarMock.daoListar(anyString())).thenReturn(lista);

        List<CarroDto> resultado = listarLibrary.ejecutar();
        assertEquals(Integer.valueOf(77), resultado.get(0).getId());
        assertEquals("Sunray", resultado.get(0).getMarca());
        System.out.println("¡YA CASI PRO!");
    }
}