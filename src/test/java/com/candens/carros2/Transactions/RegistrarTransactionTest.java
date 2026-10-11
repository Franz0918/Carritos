package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import org.junit.jupiter.api.Test;

class RegistrarTransactionTest {
    @Test
    public void posttietrans(){
    RegistrarTransaction x = new RegistrarTransaction();
    CarroDto titi = new CarroDto(11L, "Xianshin", 3, "automatica");
        x.ejecutarPost(titi);
}
}