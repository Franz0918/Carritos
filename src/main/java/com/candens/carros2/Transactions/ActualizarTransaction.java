package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import org.springframework.stereotype.Service;

//@Service("ActualizarTransaction")
public class ActualizarTransaction extends AbstractActualizarTransaction{


    public CarroDto ejecutarPut(Integer id, CarroDto dto) {

        return actualizarLibraryTransaction.ejecutar(id, dto);
    }
}
