package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoBuscarLibrary {

    public CarroDto daoBuscar(String sql,Integer id) {

        try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                //CarroDto carroEncontrado;
                if (rs.next()) { //CUANDO LLEGAR A LA DB EL PUNTERO ESTA POSICIONADO EN UNA LINEA VACIA , POSICION CERO, MUEVE EL LECTOR  ALA PARIMERA LINEA DE DATOS

                    //  carroEncontrado = new CarroDto(
                    return new CarroDto(
                            rs.getInt("id"),
                            rs.getString("marca"),
                            rs.getInt("numero_ruedas"),
                            rs.getString("tipo_transmision")
                    );
                }

                /*else {
                    throw new RuntimeException("No existe ningún carro en pgAdmin con el ID: " + id);
                }
                return carroEncontrado;  */
                return  null;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error en la consulta de búsqueda: " + e.getMessage());
        }


    }
}