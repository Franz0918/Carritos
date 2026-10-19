package com.candens.carros2.Library;

import com.candens.carros2.Library.Conexion.Conexion;
import com.candens.carros2.Library.Util.ConfigLoader;
import com.candens.carros2.Library.Util.ConfigLoaderSql;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;

//@Component
public class BorrarLibrary extends AbstractBorrarLibrary {

    @Override
    public void ejecutar(Integer id) {
        String sql = ConfigLoaderSql.getProperty("consulta.borrar");
        daoBorrarLibrary.daoBorrar(sql, id);
    }
}
