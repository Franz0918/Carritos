package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;

import com.candens.carros2.Library.Util.ConfigLoaderSql;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.List;

@Component
public class ListarLibrary extends AbstractListarLibrary{

    @Override
    public List<CarroDto> ejecutar() {
        String sql = ConfigLoaderSql.getProperty("consulta.listar");
        return daoListarLibrary.daoListar(sql);
    }
}

