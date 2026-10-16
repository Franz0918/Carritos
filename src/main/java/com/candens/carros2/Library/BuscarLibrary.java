package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import com.candens.carros2.Library.Util.ConfigLoader;
import org.springframework.stereotype.Service;
import java.sql.*;

@Service // ESTO INDICA A SPRING Q ESTO TIENE LOGICA DE NEGOCIO
public class BuscarLibrary extends AbstractBuscarLibrary {


        //AQUI EMPIEZA  A TRABAJAR BRUNO
@Override
    public CarroDto ejecutar(Integer id){//ACA SE PIDE EL ARIBUTO CREADO EN EL CONTROLADOR dto TIPO CarroDto
            String sql = ConfigLoader.getProperty("consulta.buscar");
            CarroDto carroEncontrado = null;

            // aaalll Bloque try-with-resources que maneja y cierra la conexión automáticamente
            try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql)) {
                                ps.setLong(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    // rs=mockResultSet
                    // Avanzamos el cursor a la primera fila si es que existe
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
                }

            } catch (Exception e) {
                throw new RuntimeException("Error en la consulta de búsqueda: " + e.getMessage());
            }

            // 5. Devolvemos el DTO relleno con los datos reales
            return carroEncontrado;
        }
    }

