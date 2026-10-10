package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

@Service("ActualizarTransaction")
public class ActualizarTransaction {
    private final Actualizar actualizarTransaction = new Actualizar();
    public CarroDto ejecutarPut(Long id, CarroDto dto) {
        return actualizarTransaction.ejecutar(id, dto);
    }
}
