package com.candens.carros2.Library;

import com.candens.carros2.Library.Conexion.Conexion;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class DaoBorrarLibrary {
    public void daoBorrar(String sql, Integer id) {

        try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql)) {
            //ps = mockpreparedstatement
            ps.setInt(1, id);

            int filasDeleted = ps.executeUpdate();

            if (filasDeleted == 0) {
                throw new RuntimeException("No se pudo actualizar. El carro con ID " + id + " no existe.");
            }

        } catch (Exception e) {
            throw new RuntimeException("PROBLEMITA ELIMINIAR: " + e.getMessage());
        }
    }
}