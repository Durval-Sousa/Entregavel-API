package br.com.faculdade.sistema_academico.controller;

import br.com.faculdade.sistema_academico.dto.AlunoRequest;
import br.com.faculdade.sistema_academico.dto.AlunoResponse;
import br.com.faculdade.sistema_academico.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> create(
            @RequestBody AlunoRequest request) {

        AlunoResponse response = alunoService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> getById(
            @PathVariable Long id) {

        Optional<AlunoResponse> alunoOptional = alunoService.getById(id);

        if (alunoOptional.isPresent()) {
            return ResponseEntity
                    .ok(alunoOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody AlunoRequest request) {

        alunoService.update(id, request);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {

        alunoService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}