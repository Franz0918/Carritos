package com.candens.carros2.Transactions;

import com.candens.carros2.Library.BuscarLibrary;

public class AbstractBuscarTransaction {
    protected BuscarLibrary buscarLibraryTransaction; // = new BuscarLibrary();

    public void setBuscarTransaction(BuscarLibrary buscarLibraryTransaction) {
        this.buscarLibraryTransaction = buscarLibraryTransaction;
    }
}
