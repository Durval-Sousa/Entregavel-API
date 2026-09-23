package br.com.faculdade.sistema_academico.controller;

import br.com.faculdade.sistema_academico.model.Curso;
import br.com.faculdade.sistema_academico.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Curso> salvar(@RequestBody Curso curso) {
        Curso cursoSalvo = cursoService.salvar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (cursoService.buscarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        cursoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public List<Curso> buscarPorTurno(@RequestParam String turno) {
        return cursoService.listarTodos()
                .stream()
                .filter(curso -> curso.getTurno().equalsIgnoreCase(turno))
                .toList();
    }

    @GetMapping("/ra")
    public String consultarRa() {
        return "O RA do aluno Durval é 101992";
    }
}