package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import com.candens.carros2.Library.Util.ConfigLoaderSql;
import java.util.List;

//ACA SE MODIFICO A PEDIDO DEL REN
public class ListarLibrary extends AbstractListarLibrary {

    @Override
    public List<CarroDto> ejecutar() {
        String sql = ConfigLoaderSql.getProperty("consulta.listar");
        return daoListarLibrary.daoListar(sql);
    }
}
