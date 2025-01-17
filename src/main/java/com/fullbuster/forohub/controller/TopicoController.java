package com.fullbuster.forohub.controller;

import com.fullbuster.forohub.domain.topico.*;
import com.fullbuster.forohub.domain.usuario.Usuario;
import com.fullbuster.forohub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        // Verificamos si el autor existe dentro de la base de datos
        Usuario autor = usuarioRepository.findById(datosRegistroTopico.autorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Topico topico = new Topico(datosRegistroTopico, autor);
        topico = topicoRepository.save(topico);

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getFechaCreacion(), topico.getAutor().getId(), topico.getAutor().getNombre());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }   // Terminar

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5) Pageable paginacion) {
        /*Page<Topico> topicos = topicoRepository.findAll(paginacion);
        if (topicos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Page<DatosListadoTopico> datosListadoTopico = topicos.map(DatosListadoTopico::new);
        return ResponseEntity.ok(datosListadoTopico);*/
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> obtenerMedico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getFechaCreacion(), topico.getAutor().getId(), topico.getAutor().getNombre());
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        System.out.println(topico);
        topico.actualizarDatos(datosActualizarTopico);

        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getFechaCreacion(), topico.getAutor().getId(), topico.getAutor().getNombre()));
    }

    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable Long id) {     // A través de @PathVariable indicamos que el id a eliminar se obtiene de la ruta
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

}
