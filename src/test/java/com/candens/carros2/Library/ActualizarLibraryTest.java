package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import org.junit.jupiter.api.Test;

class ActualizarLibraryTest {

    @Test
    public void puttie(){
        ActualizarLibrary x = new ActualizarLibrary();
        CarroDto tito = new CarroDto(1, "Xianshin", 3, "automatica");
        x.ejecutar(2,tito);
    }
}