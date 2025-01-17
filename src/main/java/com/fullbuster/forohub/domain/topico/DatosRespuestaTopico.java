package com.fullbuster.forohub.domain.topico;

import java.util.Date;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, String status, Date fechaCreacion, Long autorId, String autorNombre) {
}
