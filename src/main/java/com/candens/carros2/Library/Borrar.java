package com.candens.carros2.Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Borrar {
    private final String url = "jdbc:postgresql://localhost:5432/carritos";
    private final String user = "postgres";
    private final String password = "Los;petetes;2026";

    public void ejecutar(Long id) {
        String sql = "DELETE FROM carros WHERE id = ?";

        // 2. Bloque try-with-resources para manejar y cerrar la conexión automáticamente
        try (Connection conexion = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setLong(1, id);

            int filasDeleted = ps.executeUpdate();

            if (filasDeleted == 0) {
                throw new RuntimeException("No se pudo actualizar. El carro con ID " + id + " no existe.");
            }

        } catch (Exception e) {
            throw new RuntimeException("PROBLEMITA ELIMINIAR: " + e.getMessage());
        }


    }
}
