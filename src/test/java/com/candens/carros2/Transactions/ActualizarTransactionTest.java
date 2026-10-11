package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import org.junit.jupiter.api.Test;

class ActualizarTransactionTest {
    @Test
    public void puttietrans(){
        ActualizarTransaction x = new ActualizarTransaction();
        CarroDto tito = new CarroDto(1L, "Xianshin", 3, "automatica");
        x.ejecutarPut(3L,tito);
    }
}