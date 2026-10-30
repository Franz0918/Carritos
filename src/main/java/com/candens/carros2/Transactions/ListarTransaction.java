package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;


import java.util.List;


public class ListarTransaction extends AbstractListarTransaction{


    public List<CarroDto> ejecutarList() {
        return listarLibraryTransaction.ejecutar();

    }
}
