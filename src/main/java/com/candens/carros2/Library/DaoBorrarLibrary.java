package com.candens.carros2.Library;

import com.candens.carros2.Library.Conexion.Conexion;

import java.sql.PreparedStatement;

public class DaoBorrarLibrary {
    public void daoBorrar(String sql, Integer id) {
        System.out.println("entroooooo");
        try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql)) { // APUNTA AL LUGAR DONDE ESTA LO DE LA DERECHA DEL "="
            ps.setInt(1, id);

            int filasDeleted = ps.executeUpdate();
            //filasDeleted = 15; CUANDO CUALQUIER OBJETO NO TIENE ALGUIEN QUE LE APUNTE, SE BORRA
            if (filasDeleted == 0) {
                throw new RuntimeException("No se pudo actualizar. El carro con ID " + id + " no existe.");
            }

        } catch (Exception e) {
            throw new RuntimeException("PROBLEMITA ELIMINIAR: " + e.getMessage());
        }
    }
}