package com.candens.carros2.Transactions;

import org.junit.jupiter.api.Test;

class BuscarTransactionTest {
    @Test
    public void gettietran(){

        BuscarTransaction y = new BuscarTransaction();
        y.ejecutarGet(3L);
    }
}