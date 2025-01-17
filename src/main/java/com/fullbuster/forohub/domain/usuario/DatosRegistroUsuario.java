package com.fullbuster.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroUsuario(

        @NotBlank
        String nombre,
        @NotBlank
        String correo,
        @NotBlank
        String contrasena

) {
}
