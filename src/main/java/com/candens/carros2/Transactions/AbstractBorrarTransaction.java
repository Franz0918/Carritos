package com.candens.carros2.Transactions;

import com.candens.carros2.Library.BorrarLibrary;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractBorrarTransaction {
    @Autowired
    protected BorrarLibrary borrarLibraryTransaction; // = new Borrar();

    public void setBorrarLibraryTransaction(BorrarLibrary borrarLibraryTransaction) {
        this.borrarLibraryTransaction = borrarLibraryTransaction;
    }
}
