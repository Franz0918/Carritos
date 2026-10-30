package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
public class  BuscarTransaction extends AbstractBuscarTransaction{

    public CarroDto ejecutarGet(Integer id) {
        return buscarLibraryTransaction.ejecutar(id);
    }
}
