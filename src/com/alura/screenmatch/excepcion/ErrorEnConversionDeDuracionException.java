package com.alura.screenmatch.excepcion;

    // Al heredar de RuntimeException, es una excepción "No Verificada"

    public class ErrorEnConversionDeDuracionException extends RuntimeException {
        private String mensaje;

        public ErrorEnConversionDeDuracionException(String mensaje) {
            this.mensaje = mensaje;
        }

        @Override
        public String getMessage() {
            return this.mensaje;
        }
    }

