package com.candens.carros2.Library;

import com.candens.carros2.Dto.CarroDto;
import org.junit.jupiter.api.Test;

class RegistrarLibraryTest {
    @Test
    public void posttie(){
        RegistrarLibrary x = new RegistrarLibrary();
        CarroDto titi = new CarroDto(11, "Xianshin", 3, "automatica");
        x.ejecutar(titi);
    }
}