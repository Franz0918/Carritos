package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

@Service("BuscarTransaction")
public class BuscarTransaction {
    private final Buscar buscarTransaction = new Buscar();
    public CarroDto ejecutarGet(Long id) {
        return buscarTransaction.ejecutar(id);

    }
}
