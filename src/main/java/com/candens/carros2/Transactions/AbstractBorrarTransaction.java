package com.candens.carros2.Transactions;

import com.candens.carros2.Library.BorrarLibrary;

public class AbstractBorrarTransaction {

    protected BorrarLibrary borrarLibraryTransaction; // = new Borrar();

    public void setBorrarLibraryTransaction(BorrarLibrary borrarLibraryTransaction) {
        this.borrarLibraryTransaction = borrarLibraryTransaction;
    }
}
