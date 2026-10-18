package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class DaoRegistrarLibrary {
    public CarroDto daoRegistrar(String sql, CarroDto dto) {

        Integer idGenerado = null;
        try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Pasamos los parámetros de tu DTO al Query de SQL ------
            ps.setString(1, dto.getMarca());
            ps.setInt(2, dto.getNumero_ruedas());
            ps.setString(3, dto.getTipo_transmision());

            // Se ejecuta la inserción en la base de datos
            ps.executeUpdate();

            //conexion.close(); PARA CERRAR CONEXION SIN () DENTRO DEL TRY

            // ssRecuperamos el ID autoincremental que le asignó pgAdmin
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {

                    idGenerado = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al insertar el carro en la base de datos: " + e.getMessage());
        }
        // Retornamos el DTO final con su ID real de base de datos
        return new CarroDto(idGenerado, dto.getMarca(), dto.getNumero_ruedas(), dto.getTipo_transmision());
    }
}