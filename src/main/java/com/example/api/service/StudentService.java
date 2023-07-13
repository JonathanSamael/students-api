package com.example.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.api.entity.Student;

@Service
public class StudentService {
    // variável criada para pegar a lista de estudantes
    private static Map<Long, Student> listaEstudantes = new HashMap<>();

    //métodos criados para as interações do CRUD
    public ResponseEntity<Student> buscarEstudantePorId(Long id) {
        Student estudante = listaEstudantes.get(id);
        if (estudante == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(estudante);
    };
    
    public List<Student> buscarTodosEstudantes() {
        return new ArrayList<>(listaEstudantes.values());
    };
    
    public ResponseEntity<Student> cadastrarEstudante(Student estudante) {
        listaEstudantes.put(estudante.getId(), estudante);
        return ResponseEntity.status(HttpStatus.OK).body(estudante);
    };
    
    public ResponseEntity<Student> atualizarEstudante(Student estudante) {
        Student estudanteEncontrado = listaEstudantes.get(estudante.getId());
        if (estudanteEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listaEstudantes.put(estudante.getId(), estudante);
        return ResponseEntity.status(HttpStatus.OK).body(estudanteEncontrado);
    };

    public ResponseEntity<String> removerEstudante(Long id) {
        Student estudanteEncontrado = listaEstudantes.get(id);
        if (estudanteEncontrado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        listaEstudantes.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body("Estudante deletado com sucesso");
    };
}
