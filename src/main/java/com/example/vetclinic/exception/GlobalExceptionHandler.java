package com.example.vetclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AnimalNaoPertenceAoTutorException.class)
    public ResponseEntity<String> handleAnimalNaoPertence(AnimalNaoPertenceAoTutorException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(EspecialidadeIncompativelException.class)
    public ResponseEntity<String> handleEspecialidadeIncompativel(EspecialidadeIncompativelException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }

    @ExceptionHandler(VeterinarioIndisponivelException.class)
    public ResponseEntity<String> handleVeterinarioIndisponivel(VeterinarioIndisponivelException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidation(MethodArgumentNotValidException ex){
        String mensagem = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return ResponseEntity.badRequest().body(mensagem);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenerico(Exception ex) {
        return ResponseEntity.internalServerError().body("Erro interno do servidor");
    }

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<String> handleEntidadeNaoEncontrado(EntidadeNaoEncontradaException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
