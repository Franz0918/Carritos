package com.candens.carros2.Library.Conexion;

import com.candens.carros2.Library.Util.ConfigLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    String url = ConfigLoader.getProperty("spring.datasource.url");
    String user = ConfigLoader.getProperty("spring.datasource.username");
    String password = ConfigLoader.getProperty("spring.datasource.password");

    private static Conexion instancia;
    private Connection conexion;

    private Conexion() {

        try {

            this.conexion = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {

        }
   }
    public static Conexion conectar() throws SQLException {
    if(instancia == null || instancia.getConnection().isClosed())
        instancia=new Conexion();
        return instancia;
    }
    public Connection getConnection(){
        return conexion;
    }

}