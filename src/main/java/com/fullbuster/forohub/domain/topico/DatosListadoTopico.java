package com.fullbuster.forohub.domain.topico;

import java.util.Date;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String status, Date fechaCreacion, Long autorId, String autorNombre) {

    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getFechaCreacion(), topico.getAutor().getId(), topico.getAutor().getNombre());
    }

}
