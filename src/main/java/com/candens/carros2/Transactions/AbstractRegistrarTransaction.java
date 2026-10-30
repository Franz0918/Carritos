package com.candens.carros2.Transactions;

import com.candens.carros2.Library.RegistrarLibrary;
public class AbstractRegistrarTransaction {
    //@Autowired
    protected RegistrarLibrary registrarLibraryTransaction;

    public void setRegistrarLibraryTransaction(RegistrarLibrary registrarLibraryTransaction) {
        this.registrarLibraryTransaction = registrarLibraryTransaction;}
}
