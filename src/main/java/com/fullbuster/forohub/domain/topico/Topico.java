package com.fullbuster.forohub.domain.topico;

import com.fullbuster.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/* Etiquetas de persistencia */
@Table(name = "topicos")
@Entity(name = "Topico")

/* Lombok */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Topico {

    @Id     //Indica que id es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Nos permite generar el id automáticamente en la BD
    private Long id;
    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    private String status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    public Topico() {}

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario autor) {    // Terminar
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.status = datosRegistroTopico.status();
        this.fechaCreacion = new Date();
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }if (datosActualizarTopico.titulo() != null) {
            this.status = datosActualizarTopico.status();
        }
    }
}
