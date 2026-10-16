package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.BuscarLibrary;
import com.candens.carros2.Transactions.BuscarTransaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class BuscarTransactionTest2 {
  @Mock
  BuscarLibrary bl; // ACA OMITES SU CODIGO Y LO MOCKEAS (METES ALGO) Y DEVUELVE LO QUE SE LE PROGRAMA

  @InjectMocks
  BuscarTransaction tl; // A ESTE SI ENTRAS A SU CODIGO PORQ SI SE VA A PROBAR

  @Before
  public void setUp() {
      MockitoAnnotations.openMocks(this);
  }

  @Test
    public void probarBuscar(){
        //VARIABLES, WHEN , EJECUTAR, PROBAR
        when(bl.ejecutar(anyInt())).thenReturn(getDummy());
        CarroDto resultado = tl.ejecutarGet(3);
        assertEquals(Integer.valueOf(77),resultado.getId());
    }
    public CarroDto getDummy(){
        CarroDto dtoPrueba = new CarroDto(77, "Sunray", 4, "Mecánica");
        return dtoPrueba;
    }
}