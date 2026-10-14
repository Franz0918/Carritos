package com.candens.carros2.Transactions;


import com.candens.carros2.Library.BorrarLibrary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;

public class BorrarTransactionTest {

    @Mock
    private BorrarLibrary borrarLibraryTransaction; //CLON DE MENTIRA
    @InjectMocks
    private BorrarTransaction bot; //SE CREA UNA INSTANCIA REAL Y le metE el clon simulado
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); //  inicializa los mocks antes de cada test
    }
    @Test
    public void deletietrans(){

        org.mockito.Mockito.doNothing().when(borrarLibraryTransaction).ejecutar(anyInt());
        bot.ejecutarDelete(3); //AQUI PRUEBO MI TRNSACTION
        org.mockito.Mockito.verify(borrarLibraryTransaction, org.mockito.Mockito.times(1)).ejecutar(3);
    }
}

