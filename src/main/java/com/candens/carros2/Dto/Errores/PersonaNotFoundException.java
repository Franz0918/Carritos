package com.candens.carros2.Dto.Errores;

 public class PersonaNotFoundException extends RuntimeException {
        public PersonaNotFoundException(String mensage) {
            super(mensage);
        }
    }


