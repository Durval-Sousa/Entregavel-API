package br.com.faculdade.sistema_academico.repository;

import br.com.faculdade.sistema_academico.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    }
