package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import org.springframework.stereotype.Service;
import java.sql.*;


@Service // ESTO INDICA A SPRING Q ESTO TIENE LOGICA DE NEGOCIO
public class Actualizar {
    private final String url = "jdbc:postgresql://localhost:5432/carritos";
    private final String user = "postgres";
    private final String password = "Los;petetes;2026";

    public CarroDto ejecutar(Long id, CarroDto dto){//ACA SE PIDE EL ARIBUTO CREADO EN EL CONTROLADOR dto TIPO CarroDto
        String sql = "UPDATE carros SET marca = ?, numero_ruedas = ?, tipo_transmision = ? WHERE id = ?";

        // aaalll Bloque try-with-resources que maneja y cierra la conexión automáticamente
        try (Connection conexion = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Pasamos los parámetros del DTO al Query de SQL
            ps.setString(1, dto.getMarca());
            ps.setInt(2, dto.getNumero_ruedas());
            ps.setString(3, dto.getTipo_transmision());
            ps.setLong(4, id);

            // Se ejecuta la inserción en la base de datos
            int filasModificadas = ps.executeUpdate();

            if (filasModificadas==0) {
                throw new RuntimeException("No se pudo actualizar. El carrito con ID " + id + " no existe.");
            }

        } catch (Exception e) {
            throw new RuntimeException("PROBLEMITA AL INSERTAR TU CARRITO: " + e.getMessage());
        }
        // Retornamos el DTO final con su ID real de base de datos
        return new CarroDto(id, dto.getMarca(), dto.getNumero_ruedas(), dto.getTipo_transmision());

    }

}
