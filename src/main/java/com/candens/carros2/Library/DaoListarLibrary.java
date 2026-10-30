package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DaoListarLibrary {

    public List<CarroDto> daoListar(String sql) {
        List<CarroDto> listaCarros = new java.util.ArrayList<>();

        // aaalll Bloque try-with-resources que maneja y cierra la conexión automáticamente
        try (
                PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql);

                ResultSet rs = ps.executeQuery()) {
//rs = mockResultSet
            while (rs.next()) {

                CarroDto carro = new CarroDto(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getInt("numero_ruedas"),
                        rs.getString("tipo_transmision")
                );
                // Añadimos cada carro procesado a nuestra lista dinámica de Java
                listaCarros.add(carro);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al listar los carros de la base de datos: " + e.getMessage());
        }

        // Devolvemos la lista completa empaquetada
        return listaCarros;
    }
}