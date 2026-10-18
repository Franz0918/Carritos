package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Util.ConfigLoaderSql;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BuscarLibrary extends AbstractBuscarLibrary {


        //AQUI EMPIEZA  A TRABAJAR BRUNO
    @Override
    public CarroDto ejecutar(Integer id) {//ACA SE PIDE EL ARIBUTO CREADO EN EL CONTROLADOR dto TIPO CarroDto
        String sql = ConfigLoaderSql.getProperty("consulta.buscar");
        return daoBuscarLibrary.daoBuscar(sql, id);
    }
}