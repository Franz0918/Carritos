package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

//@Repository
public class DaoActualizarLibrary {

    public CarroDto daoActualizar(String sql, Integer id, CarroDto dto) {

        try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql)) {

            // Pasamos los parámetros del DTO al Query de SQL
            ps.setString(1, dto.getMarca());
            ps.setInt(2, dto.getNumero_ruedas());
            ps.setString(3, dto.getTipo_transmision());
            ps.setInt(4, id);

            // Se ejecuta la inserción en la base de datos
            int filasModificadas = ps.executeUpdate();

            if (filasModificadas == 0) {
                throw new RuntimeException("No se pudo actualizar. El carrito con ID " + id + " no existe.");
            }

        } catch (Exception e) {
            throw new RuntimeException("PROBLEMITA AL ACTUALIZAR TU CARRITO: " + e.getMessage());
        }
        // Retornamos el DTO final con su ID real de base de datos
        return new CarroDto(id, dto.getMarca(), dto.getNumero_ruedas(), dto.getTipo_transmision());
    }
}