package com.candens.carros2.Dto.Errores;

public class ErrorFranz{ // SOLO PUEDE SER CLASE ---Clase genérica reutilizable para cualquier tipo de error en la API

        private String error;
        private String mensajito;
        private int status;

        // CONSTRUCTOR
        public ErrorFranz(String error, String mensajito, int status) {
            this.error = error;
            this.mensajito = mensajito;
            this.status = status;
        }

        // GETERS -...
        public String getError() { return error; }
        public void setError(String error) { this.error = error; }

        public String getMensajito() { return mensajito; }
        public void setMensajito(String mensajito) { this.mensajito = mensajito; }

        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }
    }



