package br.com.faculdade.sistema_academico.service;

import br.com.faculdade.sistema_academico.dto.AlunoRequest;
import br.com.faculdade.sistema_academico.dto.AlunoResponse;
import br.com.faculdade.sistema_academico.model.Aluno;
import br.com.faculdade.sistema_academico.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import br.com.faculdade.sistema_academico.Exception.RecursoNaoEncontradoException;

import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponse create(AlunoRequest request) {
        Aluno aluno = new Aluno();

        aluno.setNome(request.getNome());
        aluno.setRa(request.getRa());

        Aluno alunoSalvo = alunoRepository.save(aluno);

        return converterParaResponse(alunoSalvo);
    }

    public Optional<AlunoResponse> getById(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            AlunoResponse response = converterParaResponse(aluno);
            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }

    public void update(Long id, AlunoRequest request) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno não encontrado"));

        aluno.setNome(request.getNome());
        aluno.setRa(request.getRa());

        alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {
        boolean existe = alunoRepository.existsById(id);

        if (!existe) {
            throw new RecursoNaoEncontradoException("Aluno não encontrado");
        }

        alunoRepository.deleteById(id);
    }

    private AlunoResponse converterParaResponse(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getRa()
        );
    }
}