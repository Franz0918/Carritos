package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import org.springframework.stereotype.Service;

//@Service("RegistrarTransaction")
public class RegistrarTransaction extends AbstractRegistrarTransaction{

        public CarroDto ejecutarPost(CarroDto dto) {
            return registrarLibraryTransaction.ejecutar(dto);

        }
    }
