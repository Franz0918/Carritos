package com.candens.carros2.Transactions;

import com.candens.carros2.Library.ActualizarLibrary;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractActualizarTransaction {
    @Autowired
    protected ActualizarLibrary actualizarLibraryTransaction;

    public void setActualizarTransaction(ActualizarLibrary actualizarLibraryTransaction) {
        this.actualizarLibraryTransaction = actualizarLibraryTransaction;
    }
}