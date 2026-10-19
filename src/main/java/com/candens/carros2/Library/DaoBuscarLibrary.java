package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

//@Repository
public class DaoBuscarLibrary {

    public CarroDto daoBuscar(String sql,Integer id) {

        try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql)) {
            //ps.setLong(1, id);
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                // rs=mockResultSet
                // Avanzamos el cursor a la primera fila si es que existe
                CarroDto carroEncontrado;
                if (rs.next()) { //CUANDO LLEGAR A LA DB EL PUNTERO ESTA POSICIONADO EN UNA LINEA VACIA , POSICION CERO, MUEVE EL LECTOR  ALA PARIMERA LINEA DE DATOS
                    // rs=mockResultSet
                    // true   -----POR ENDE HACE LO Q SIGUE
                     carroEncontrado = new CarroDto(
                            rs.getInt("id"),
                            rs.getString("marca"),
                            rs.getInt("numero_ruedas"),
                            rs.getString("tipo_transmision")
                    );
                } else {
                    throw new RuntimeException("No existe ningún carro en pgAdmin con el ID: " + id);
                }
                return carroEncontrado;
            }

        } catch (Exception e) {
            throw new RuntimeException("Error en la consulta de búsqueda: " + e.getMessage());
        }


    }
}