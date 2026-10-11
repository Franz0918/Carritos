package com.candens.carros2.Transactions;

import org.junit.jupiter.api.Test;

class BorrarTransactionTest {
    @Test
    public void deletietran(){
        BorrarTransaction x = new BorrarTransaction();
        x.ejecutarDelete(3L);
    }
}