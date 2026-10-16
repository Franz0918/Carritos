package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import com.candens.carros2.Library.Util.ConfigLoader;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.List;

@Service // ESTO INDICA A SPRING Q ESTO TIENE LOGICA DE NEGOCIO
public class ListarLibrary extends AbstractListarLibrary{

    @Override
    public List<CarroDto> ejecutar() {
        // Sentencia SQL nativa para traer todas las filas ordenadas por ID
        //String sql = "SELECT id, marca, numero_ruedas, tipo_transmision FROM carros ORDER BY id ASC";
        String sql = ConfigLoader.getProperty("consulta.listar");
        List<CarroDto> listaCarros = new java.util.ArrayList<>();

        // aaalll Bloque try-with-resources que maneja y cierra la conexión automáticamente
        try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {
//rs = mockResultSet
            while (rs.next()){

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

