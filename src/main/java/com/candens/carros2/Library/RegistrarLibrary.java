package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Conexion.Conexion;
import com.candens.carros2.Library.Util.ConfigLoader;
import com.candens.carros2.Library.Util.ConfigLoaderSql;
import org.springframework.stereotype.Component;

@Component // ESTO INDICA A SPRING Q ESTO TIENE LOGICA DE NEGOCIO
public class RegistrarLibrary extends AbstractRegistrarLibrary{


    //AQUI EMPIEZA  A TRABAJAR BRUNO
@Override
    public CarroDto ejecutar(CarroDto dto){//ACA SE PIDE EL ARIBUTO CREADO EN EL CONTROLADOR dto TIPO CarroDto
        //String sql = "INSERT INTO carros (marca, numero_ruedas, tipo_transmision) VALUES (?, ?, ?)";//QUERY/CONSULTA
        String sql = ConfigLoaderSql.getProperty("consulta.registrar");
/*-----------------------------------------------
        // aaalll Bloque try-with-resources que maneja y cierra la conexión automáticamente
        try (PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql)) {

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
*/
        return daoRegistrarLibrary.daoRegistrar(sql, dto);
    }
}
