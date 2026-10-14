package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

@Service("ActualizarTransaction")
public class ActualizarTransaction {
    private final ActualizarLibrary actualizarLibraryTransaction; // = new Actualizar();
    public ActualizarTransaction(ActualizarLibrary actualizarLibraryTransaction) {
        this.actualizarLibraryTransaction = actualizarLibraryTransaction;
    }
    public CarroDto ejecutarPut(Integer id, CarroDto dto) {
        return actualizarLibraryTransaction.ejecutar(id, dto);
    }
}
