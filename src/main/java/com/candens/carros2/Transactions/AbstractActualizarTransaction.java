package com.candens.carros2.Transactions;

import com.candens.carros2.Library.ActualizarLibrary;

public class AbstractActualizarTransaction {
    protected ActualizarLibrary actualizarLibraryTransaction;

    public void setActualizarTransaction(ActualizarLibrary actualizarLibraryTransaction) {
        this.actualizarLibraryTransaction = actualizarLibraryTransaction;
    }
}