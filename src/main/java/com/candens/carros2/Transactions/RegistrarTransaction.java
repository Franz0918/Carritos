package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

@Service("RegistrarTransaction")
public class RegistrarTransaction {
        private final RegistrarLibrary registrarLibraryTransaction; // = new Registrar();
        public RegistrarTransaction(RegistrarLibrary registrarLibraryTransaction) {this.registrarLibraryTransaction = registrarLibraryTransaction;}
        public CarroDto ejecutarPost(CarroDto dto) {
            return registrarLibraryTransaction.ejecutar(dto);

            //CarroDto enviaPost =
            //return enviaPost;
        }
    }
