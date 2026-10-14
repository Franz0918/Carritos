package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.ActualizarLibrary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class ActualizarTransactionTest {

    @Mock
    private ActualizarLibrary actualizarLibraryTransaction; //CLON DE MENTIRA
    @InjectMocks
    private ActualizarTransaction at; //SE CREA UNA INSTANCIA REAL Y le metE el clon simulado
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); //  inicializa los mocks antes de cada test
    }

    @Test
    public void puttietrans(){

        CarroDto tito = new CarroDto(3, "Xianshin", 3, "automatica"); // SOLO CREO UN CARRODTO
        when(actualizarLibraryTransaction.ejecutar(anyInt(), any(CarroDto.class))).thenReturn(tito); // ACA LED IGO COMO HACER EL ENGAÑO
        CarroDto resultado = at.ejecutarPut(3,tito); //AQUI PRUEBO MI TRNSACTION

        System.out.println("ID devuelto: " + resultado.getId());
        System.out.println("Marca devuelta: " + resultado.getMarca());

        assertEquals(Integer.valueOf(3), resultado.getId());
    }
}
