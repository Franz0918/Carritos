package com.candens.carros2.Library;

import com.candens.carros2.Library.Conexion.Conexion;
import com.candens.carros2.Library.Util.ConfigLoader;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;

@Service
public class BorrarLibrary implements InterfaceBorrarLibrary {

    @Override
    public void ejecutar(Integer id) {
        //String sql = "DELETE FROM carros WHERE id = ?";
        String sql = ConfigLoader.getProperty("consulta.borrar");

        // 2. Bloque try-with-resources para manejar y cerrar la conexión automáticamente
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
