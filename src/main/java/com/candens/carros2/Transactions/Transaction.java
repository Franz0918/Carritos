package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.*;
import org.springframework.stereotype.Service;

import java.util.List;

public class Transaction {

    //POST...
    @Service("RegistrarCarroEnvio")
    public static class RegistrarCarroEnvio {
        private final Registrar registrarTransaction = new Registrar();
        public CarroDto ejecutarPost(CarroDto dto) {
             return registrarTransaction.ejecutar(dto);

            //CarroDto enviaPost =
            //return enviaPost;
        }
    }

    //GETs
    @Service("BuscarCarroEnvio")
    public static class BuscarCarroEnvio {
        private final Buscar buscarTransaction = new Buscar();
        public CarroDto ejecutarGet(Long id) {
            return buscarTransaction.ejecutar(id);


        }
    }


    //LIST
    @Service("ListaCarroEnvio")
    public static class ListaCarroEnvio {
        private final Listar listarTransaction = new Listar();
        public List<CarroDto> ejecutarList() {
            return listarTransaction.ejecutar();


        }

    }

    //PUT
    @Service("ActualizarCarroEnvio")
    public static class ActualizarCarroEnvio {
        private final Actualizar actualizarTransaction = new Actualizar();
        public CarroDto ejecutarPut(Long id, CarroDto dto) {
            return actualizarTransaction.ejecutar(id, dto);


        }
    }

    //BORRAR
    @Service("BorrarCarroEnvio")
    public static class BorrarCarroEnvio {
        private final Borrar borrarTransaction = new Borrar();
        public void ejecutarDelete(Long id) {
            borrarTransaction.ejecutar(id);

        }
    }
}