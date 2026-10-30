package com.candens.carros2.Library;

import com.candens.carros2.Library.Util.ConfigLoaderSql;
public class BorrarLibrary extends AbstractBorrarLibrary {
    @Override
    public void ejecutar(Integer id) {
        String sql = ConfigLoaderSql.getProperty("consulta.borrar"); // QUERY
        daoBorrarLibrary.daoBorrar(sql, id);
    }
}
