package com.candens.carros2.Transactions;

import com.candens.carros2.Library.BuscarLibrary;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractBuscarTransaction {
    @Autowired
    protected BuscarLibrary buscarLibraryTransaction; // = new BuscarLibrary();

    public void setBuscarTransaction(BuscarLibrary buscarLibraryTransaction) {
        this.buscarLibraryTransaction = buscarLibraryTransaction;
    }
}
