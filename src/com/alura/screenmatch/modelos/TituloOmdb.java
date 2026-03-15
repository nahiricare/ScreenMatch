package com.alura.screenmatch.modelos;
import com.google.gson.annotations.Expose;


public record TituloOmdb(
        @Expose String Title,
        @Expose String Year,
        @Expose String Runtime
) {
}