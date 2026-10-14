package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.ListarLibrary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.junit.Assert.assertEquals;


public class ListarTransactionTest {
    @Mock
    private ListarLibrary listarLibraryTransaction; //CLON DE MENTIRA
    @InjectMocks
    private ListarTransaction lt; //SE CREA UNA INSTANCIA REAL Y le metE el clon simulado
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); //  inicializa los mocks antes de cada test
    }
    @Test
    public void listietrans(){

        CarroDto tito = new CarroDto(3, "Xianshin", 3, "automatica"); // SOLO CREO UN CARRODTO
        java.util.List<CarroDto> listaMock = java.util.Collections.singletonList(tito);
        org.mockito.Mockito.when(listarLibraryTransaction.ejecutar()).thenReturn(listaMock);

        java.util.List<CarroDto> resultado = lt.ejecutarList(); //AQUI PRUEBO MI TRNSACTION

        System.out.println("ID devuelto: " + resultado.get(0).getId());
        System.out.println("Marca devuelta: " + resultado.get(0).getMarca());

        assertEquals(Integer.valueOf(3), resultado.get(0).getId());
        assertEquals(1, resultado.size());
    }
    }