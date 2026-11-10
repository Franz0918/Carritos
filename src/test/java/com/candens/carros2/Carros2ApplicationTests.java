package com.candens.carros2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
class Carros2ApplicationTests {

	@Disabled //ES PARA DESACTIVAR LAS SOLICITUDES A LA BASE DE DATOS CUANDO SE HACEN PRUEBAS UNITARIAS EN GIT
	@Test
	void contextLoads() {
	}

}
