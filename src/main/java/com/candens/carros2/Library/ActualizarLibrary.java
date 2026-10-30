package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Util.ConfigLoaderSql;

public class ActualizarLibrary extends AbstractActualizarLibrary{


    @Override
    public CarroDto ejecutar(Integer id, CarroDto dto){
        try {
        String sql = ConfigLoaderSql.getProperty("consulta.actualizar");
        return daoActualizarLibrary.daoActualizar(sql, id, dto);
        } catch (Exception e){
            return null;
        }
    }
}
