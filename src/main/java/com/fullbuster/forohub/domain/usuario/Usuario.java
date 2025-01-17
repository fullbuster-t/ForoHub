package com.fullbuster.forohub.domain.usuario;

import com.fullbuster.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

/* Etiquetas de persistencia */
@Table(name = "usuarios")
@Entity(name = "Usuario")

/* Lombok */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario {

    @Id     //Indica que id es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Nos permite generar el id automáticamente en la BD
    private Long id;
    private String nombre;
    private String correo;
    private String contrasena;

    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos;

    public Usuario() {}

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.nombre = datosRegistroUsuario.nombre();
        this.correo = datosRegistroUsuario.correo();
        this.contrasena = datosRegistroUsuario.contrasena();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
        if (datosActualizarUsuario.nombre() != null) {
            this.nombre = datosActualizarUsuario.nombre();
        }
        if (datosActualizarUsuario.correo() != null) {
            this.correo = datosActualizarUsuario.correo();
        }
        if (datosActualizarUsuario.contrasena() != null) {
            this.contrasena = datosActualizarUsuario.contrasena();
        }
    }



}
