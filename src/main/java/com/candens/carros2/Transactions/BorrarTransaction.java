package com.candens.carros2.Transactions;

import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

@Service("BorrarTransaction")
public class BorrarTransaction {
    private final BorrarLibrary borrarLibraryTransaction; // = new Borrar();
    public BorrarTransaction(BorrarLibrary borrarLibraryTransaction) {
        this.borrarLibraryTransaction = borrarLibraryTransaction;
    }

    public void ejecutarDelete(Integer id) {
        borrarLibraryTransaction.ejecutar(id);

    }
}
