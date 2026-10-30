package com.candens.carros2.Library;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class BorrarLibraryTest {
    @Mock
    private DaoBorrarLibrary daoBorrarMock;

    @InjectMocks
    private BorrarLibrary borrarLibrary;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void buscarLibPrueba() {

        doNothing().when(daoBorrarMock).daoBorrar(anyString(),anyInt());
        borrarLibrary.ejecutar(3);
        verify(daoBorrarMock, times(1)).daoBorrar(anyString(), eq(3));
        System.out.println("¡YA CASI PRO!");
    }
}