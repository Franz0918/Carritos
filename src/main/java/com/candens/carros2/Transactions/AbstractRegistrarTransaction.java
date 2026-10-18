package com.candens.carros2.Transactions;

import com.candens.carros2.Library.RegistrarLibrary;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractRegistrarTransaction {
    @Autowired
    protected RegistrarLibrary registrarLibraryTransaction; // = new Registrar();

    public void setRegistrarLibraryTransaction(RegistrarLibrary registrarLibraryTransaction) {
        this.registrarLibraryTransaction = registrarLibraryTransaction;}
}
