package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import org.junit.jupiter.api.Test;

class RegistrarTest {
    @Test
    public void posttie(){
        Registrar x = new Registrar();
        CarroDto titi = new CarroDto(11L, "Xianshin", 3, "automatica");
        x.ejecutar(titi);
    }
}