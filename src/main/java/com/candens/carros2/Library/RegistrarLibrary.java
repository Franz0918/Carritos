package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Util.ConfigLoaderSql;

public class RegistrarLibrary extends AbstractRegistrarLibrary{

@Override
    public CarroDto ejecutar(CarroDto dto){//ACA SE PIDE EL ARIBUTO CREADO EN EL CONTROLADOR dto TIPO CarroDto
        String sql = ConfigLoaderSql.getProperty("consulta.registrar");
        return daoRegistrarLibrary.daoRegistrar(sql, dto);
    }
}
