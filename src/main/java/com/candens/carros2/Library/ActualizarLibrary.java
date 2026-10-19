package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Util.ConfigLoaderSql;
import org.springframework.stereotype.Component;

@Component
public class ActualizarLibrary extends AbstractActualizarLibrary{

    @Override
    public CarroDto ejecutar(Integer id, CarroDto dto){//ACA SE PIDE EL ARIBUTO CREADO EN EL CONTROLADOR dto TIPO CarroDto
        String sql = ConfigLoaderSql.getProperty("consulta.actualizar");

/*-----------------------------------------------------------------
       try( PreparedStatement ps = Conexion.conectar().getConnection().prepareStatement(sql))  {

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
            throw new RuntimeException("PROBLEMITA AL ACTUALIZAR TU CARRITO: " + e.getMessage());
        }
        // Retornamos el DTO final con su ID real de base de datos
        return new CarroDto(id, dto.getMarca(), dto.getNumero_ruedas(), dto.getTipo_transmision());
//-----------------------------------------------------------------*/
        return daoActualizarLibrary.daoActualizar(sql, id, dto);
    }

}
