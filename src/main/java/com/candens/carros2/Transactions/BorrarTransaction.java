package com.candens.carros2.Transactions;

import org.springframework.stereotype.Service;

//@Service("BorrarTransaction")
public class BorrarTransaction extends AbstractBorrarTransaction{

    public void ejecutarDelete(Integer id) {
        borrarLibraryTransaction.ejecutar(id);

    }
}
