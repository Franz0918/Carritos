package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

@Service("BuscarTransaction")
public class BuscarTransaction {
    private final BuscarLibrary buscarLibraryTransaction; // = new Buscar();
    public BuscarTransaction(BuscarLibrary buscarLibraryTransaction) {this.buscarLibraryTransaction = buscarLibraryTransaction;}
    public CarroDto ejecutarGet(Integer id) {
        return buscarLibraryTransaction.ejecutar(id);

    }
}
