package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class RegistrarLibraryTest {
    @Mock // <-- Fabrica el clon del DAO automáticamente
    private DaoRegistrarLibrary daoRegistrarMock;

    @InjectMocks // <-- Crea la instancia real e intenta meter los @Mock adentro
    private RegistrarLibrary registrarLibrary;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); //  inicializa los mocks antes de cada test
    }

    @Test
    public void registrarLibPrueba() {
        CarroDto carroEntra = new CarroDto(77, "Sunray", 4, "Mecánica");
        CarroDto carroSale = new CarroDto(77, "Sunray", 4, "Mecánica");

        //ENTRENANDO AL MOCK
        when(daoRegistrarMock.daoRegistrar(anyString(), any(CarroDto.class))).thenReturn(carroSale);
        CarroDto resultado = registrarLibrary.ejecutar(carroEntra);

        assertEquals(Integer.valueOf(77), resultado.getId());
        assertEquals("Sunray", resultado.getMarca());
        System.out.println("¡YA CASI PRO!");
    }
}