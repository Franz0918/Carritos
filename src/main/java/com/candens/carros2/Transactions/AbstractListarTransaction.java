package com.candens.carros2.Transactions;

import com.candens.carros2.Library.ListarLibrary;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractListarTransaction {
    //@Autowired
    protected ListarLibrary listarLibraryTransaction; // = new Listar();

    public void setListarTransaction(ListarLibrary listarLibraryTransaction) {
        this.listarLibraryTransaction = listarLibraryTransaction;}
}
