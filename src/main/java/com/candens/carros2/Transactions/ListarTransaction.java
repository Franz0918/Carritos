package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ListarTransaction")
public class ListarTransaction {

    private final ListarLibrary listarLibraryTransaction; // = new Listar();
    public ListarTransaction(ListarLibrary listarLibraryTransaction) {this.listarLibraryTransaction = listarLibraryTransaction;}
    public List<CarroDto> ejecutarList() {
        return listarLibraryTransaction.ejecutar();

    }
}
