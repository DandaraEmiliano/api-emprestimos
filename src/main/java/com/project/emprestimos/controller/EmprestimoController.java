package com.project.emprestimos.controller;

import com.project.emprestimos.dto.EmprestimoRequestDTO;
import com.project.emprestimos.dto.EmprestimoResponseDTO;
import com.project.emprestimos.service.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @Operation(summary = "Cria um novo empréstimo")
    @PostMapping
    public ResponseEntity<EmprestimoResponseDTO> criar(@Valid @RequestBody EmprestimoRequestDTO dto) {
        EmprestimoResponseDTO response = service.criar(dto);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Lista todos os empréstimos")
    @GetMapping
    public ResponseEntity<List<EmprestimoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(summary = "Busca um empréstimo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @Operation(summary = "Atualiza um empréstimo existente")
    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoResponseDTO> atualizar(@PathVariable Long id,
                                                           @Valid @RequestBody EmprestimoRequestDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @Operation(summary = "Deleta um empréstimo por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
