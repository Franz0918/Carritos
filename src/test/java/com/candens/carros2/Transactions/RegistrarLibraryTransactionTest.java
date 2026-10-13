package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.RegistrarLibrary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


public class RegistrarLibraryTransactionTest {
    @Mock
    private RegistrarLibrary registrarLibraryTransaction; //CLON DE MENTIRA
    @InjectMocks
    private RegistrarTransaction rt; //SE CREA UNA INSTANCIA REAL Y le metE el clon simulado
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); //  inicializa los mocks antes de cada test
    }
    @Test
    public void posttietrans(){

        CarroDto tito = new CarroDto(3, "Xianshin", 3, "automatica"); // SOLO CREO UN CARRODTO
        when(registrarLibraryTransaction.ejecutar(any(CarroDto.class))).thenReturn(tito); // ACA LED IGO COMO HACER EL ENGAÑO
        CarroDto resultado = rt.ejecutarPost(tito); //AQUI PRUEBO MI TRNSACTION

        System.out.println("ID devuelto: " + resultado.getId());
        System.out.println("Marca devuelta: " + resultado.getMarca());

        assertEquals(Integer.valueOf(3), resultado.getId());
    }
}