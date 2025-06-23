package com.project.emprestimos.service;

import com.project.emprestimos.dto.EmprestimoRequestDTO;
import com.project.emprestimos.dto.EmprestimoResponseDTO;
import com.project.emprestimos.model.Emprestimo;
import com.project.emprestimos.repository.EmprestimoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    private final EmprestimoRepository repository;

    public EmprestimoService(EmprestimoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public EmprestimoResponseDTO criar(EmprestimoRequestDTO dto) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(dto.getCliente());
        emprestimo.setValor(dto.getValor());
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());

        Emprestimo salvo = repository.save(emprestimo);
        return toDTO(salvo);
    }

    public List<EmprestimoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EmprestimoResponseDTO buscarPorId(Long id) {
        Emprestimo emprestimo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empréstimo não encontrado"));
        return toDTO(emprestimo);
    }

    @Transactional
    public EmprestimoResponseDTO atualizar(Long id, EmprestimoRequestDTO dto) {
        Emprestimo emprestimo = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Empréstimo não encontrado"));

        emprestimo.setCliente(dto.getCliente());
        emprestimo.setValor(dto.getValor());
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());

        Emprestimo atualizado = repository.save(emprestimo);
        return toDTO(atualizado);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Empréstimo não encontrado");
        }
        repository.deleteById(id);
    }

    private EmprestimoResponseDTO toDTO(Emprestimo emprestimo) {
        return new EmprestimoResponseDTO(
                emprestimo.getId(),
                emprestimo.getCliente(),
                emprestimo.getValor(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao()
        );
    }
}
