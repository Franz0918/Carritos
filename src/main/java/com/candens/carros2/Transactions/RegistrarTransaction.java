package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
public class RegistrarTransaction extends AbstractRegistrarTransaction{

        public CarroDto ejecutarPost(CarroDto dto) {
            return registrarLibraryTransaction.ejecutar(dto);

        }
    }
