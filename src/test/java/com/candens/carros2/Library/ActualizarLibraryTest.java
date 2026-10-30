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

public class ActualizarLibraryTest {
    @Mock // <-- Fabrica el clon del DAO automáticamente
    private DaoActualizarLibrary daoActualizarMock;

    @InjectMocks // <-- Crea la instancia real e intenta meter los @Mock adentro
    private ActualizarLibrary actualizarLibrary;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); //  inicializa los mocks antes de cada test
    }

    @Test
    public void actualizarLibPrueba() {
        CarroDto carroEntra = new CarroDto(77, "Sunray", 4, "Mecánica");
        CarroDto carroSale = new CarroDto(77, "Sunray", 4, "Mecánica");

        //ENTRENANDO AL MOCK
        when(daoActualizarMock.daoActualizar(anyString(), anyInt(),any(CarroDto.class))).thenReturn(carroSale);
        CarroDto resultado = actualizarLibrary.ejecutar(77,carroEntra);

        assertEquals(Integer.valueOf(77), resultado.getId());
        assertEquals("Sunray", resultado.getMarca());
        assertEquals("Mecánica", resultado.getTipo_transmision());
        System.out.println("¡YA CASI PRO!");
    }
}