package com.candens.carros2.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CarroDto {
    private Integer id; // creA UN OBJETO DE TIPO NUMERICO Q TIUENE LA CAPCIDAD DE GUARDAR UN VALOR NUL, en proGRAMACION SE USA POR BUENAS PRACTICAS USAR LONG PARA ESCALABILIDAD DEBIDO A QUE USA 64BITS
    @NotBlank(message = "La marca del carro es obligatoria.")
    private String marca;
    @NotNull(message = "El número de ruedas es obligatorio.")
    private Integer numero_ruedas;
    @NotBlank(message = "El tipo de transmisión es obligatorio.")
    private String tipo_transmision;

    //.CONSTRUCTOR

    public CarroDto(Integer id, String marca, Integer numero_ruedas, String tipo_transmision) { //PARA FABRICAR UN CARRODTO NECESITAS PADARME ID, MARCA,ETC
        this.id = id;
        this.marca = marca;
        this.numero_ruedas = numero_ruedas;
        this.tipo_transmision = tipo_transmision;
    }

//GETTERS Y STTERES kkkkk
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getNumero_ruedas() {
        return numero_ruedas;
    } // AQUI SE CAMBIO EN int POR EL Integer

    public void setNumero_ruedas(Integer numero_ruedas) {
        this.numero_ruedas = numero_ruedas;
    }

    public String getTipo_transmision() {
        return tipo_transmision;
    }

    public void setTipo_transmision(String tipo_transmision) {
        this.tipo_transmision = tipo_transmision;
    }
}
