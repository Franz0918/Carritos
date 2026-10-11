package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import org.junit.jupiter.api.Test;

class ActualizarTest {
    @Test
    public void puttie(){
        Actualizar x = new Actualizar();
        CarroDto tito = new CarroDto(1L, "Xianshin", 3, "automatica");
        x.ejecutar(2L,tito);
    }
}