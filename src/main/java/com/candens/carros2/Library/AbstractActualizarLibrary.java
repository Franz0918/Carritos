package com.candens.carros2.Library;

import com.candens.carros2.Library.Conexion.Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AbstractActualizarLibrary implements InterfaceActualizarLibrary{
    PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement("sql");

    protected AbstractActualizarLibrary() throws SQLException {
    }


    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }
}
