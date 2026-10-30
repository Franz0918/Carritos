package com.candens.carros2.Transactions;

import com.candens.carros2.Library.BuscarLibrary;
public class AbstractBuscarTransaction {
    protected BuscarLibrary buscarLibraryTransaction;

    public void setBuscarTransaction(BuscarLibrary buscarLibraryTransaction) {
        this.buscarLibraryTransaction = buscarLibraryTransaction;
    }
}
