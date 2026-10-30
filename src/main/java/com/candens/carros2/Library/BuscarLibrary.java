package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Util.ConfigLoaderSql;
public class BuscarLibrary extends AbstractBuscarLibrary {

   @Override
    public CarroDto ejecutar(Integer id) {//ACA SE PIDE EL ARIBUTO CREADO EN EL CONTROLADOR dto TIPO CarroDto
        String sql = ConfigLoaderSql.getProperty("consulta.buscar");
        return daoBuscarLibrary.daoBuscar(sql, id);
    }
}