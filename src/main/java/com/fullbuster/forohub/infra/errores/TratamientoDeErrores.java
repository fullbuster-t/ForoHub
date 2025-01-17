package com.fullbuster.forohub.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamientoDeErrores {

    @ExceptionHandler(EntityNotFoundException.class)    // Le indicamos sobre que excepción debe actuar el method
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();   // La pasamos la respuesta que tendremos dentro de la excepción
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {   // Para devolver una lista de los errores que tiene el cliente debemos usar como parámetro la excepcion pàra acceder a ellos
        var errores = e.getFieldErrors().stream()
                .map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    private record DatosErrorValidacion(String campo, String error) {
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
