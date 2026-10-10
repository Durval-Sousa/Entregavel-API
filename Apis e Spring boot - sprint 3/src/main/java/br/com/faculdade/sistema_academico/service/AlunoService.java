package br.com.faculdade.sistema_academico.service;

import br.com.faculdade.sistema_academico.dto.AlunoRequest;
import br.com.faculdade.sistema_academico.dto.AlunoResponse;
import br.com.faculdade.sistema_academico.model.Aluno;
import br.com.faculdade.sistema_academico.repository.AlunoRepository;
import org.springframework.stereotype.Service;

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

    public boolean update(Long id, AlunoRequest request) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setNome(request.getNome());
            aluno.setRa(request.getRa());

            alunoRepository.save(aluno);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            alunoRepository.delete(aluno);
            return true;
        } else {
            return false;
        }
    }

    private AlunoResponse converterParaResponse(Aluno aluno) {
        AlunoResponse response = new AlunoResponse();
        response.setId(aluno.getId());
        response.setNome(aluno.getNome());
        response.setRa(aluno.getRa());
        return response;
    }
}
