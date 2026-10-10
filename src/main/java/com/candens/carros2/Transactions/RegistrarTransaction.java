package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

@Service("RegistrarTransaction")
public class RegistrarTransaction {
        private final Registrar registrarTransaction = new Registrar();
        public CarroDto ejecutarPost(CarroDto dto) {
            return registrarTransaction.ejecutar(dto);

            //CarroDto enviaPost =
            //return enviaPost;
        }
    }
