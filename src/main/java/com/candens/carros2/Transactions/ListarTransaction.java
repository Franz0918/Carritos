package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ListarTransaction")
public class ListarTransaction {
    private final Listar listarTransaction = new Listar();
    public List<CarroDto> ejecutarList() {
        return listarTransaction.ejecutar();

    }
}
