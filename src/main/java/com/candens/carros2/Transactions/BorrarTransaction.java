package com.candens.carros2.Transactions;

public class BorrarTransaction extends AbstractBorrarTransaction{

    public void ejecutarDelete(Integer id) {
        borrarLibraryTransaction.ejecutar(id);
    }
}
