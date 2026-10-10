package com.candens.carros2.Transactions;

import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

@Service("BorrarTransaction")
public class BorrarTransaction {
    private final Borrar borrarTransaction = new Borrar();
    public void ejecutarDelete(Long id) {
        borrarTransaction.ejecutar(id);

    }
}
