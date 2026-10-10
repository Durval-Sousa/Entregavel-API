package br.com.faculdade.sistema_academico.controller;

import br.com.faculdade.sistema_academico.dto.AlunoRequest;
import br.com.faculdade.sistema_academico.dto.AlunoResponse;
import br.com.faculdade.sistema_academico.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/aluno")
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

        Optional<AlunoResponse> alunoOptional =
                alunoService.getById(id);

        if (alunoOptional.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(alunoOptional.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody AlunoRequest request) {

        boolean atualizado = alunoService.update(id, request);

        if (atualizado) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        boolean removido = alunoService.delete(id);

        if (removido) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }
}
