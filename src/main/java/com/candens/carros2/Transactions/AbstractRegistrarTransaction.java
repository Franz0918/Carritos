package com.candens.carros2.Transactions;

import com.candens.carros2.Library.RegistrarLibrary;

public class AbstractRegistrarTransaction {
    protected RegistrarLibrary registrarLibraryTransaction; // = new Registrar();

    public void setRegistrarLibraryTransaction(RegistrarLibrary registrarLibraryTransaction) {
        this.registrarLibraryTransaction = registrarLibraryTransaction;}
}
