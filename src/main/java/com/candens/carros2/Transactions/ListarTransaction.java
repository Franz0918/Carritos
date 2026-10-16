package com.candens.carros2.Transactions;

import com.candens.carros2.Dto.CarroDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ListarTransaction")
public class ListarTransaction extends AbstractListarTransaction{


    public List<CarroDto> ejecutarList() {
        return listarLibraryTransaction.ejecutar();

    }
}
