package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Semafaro;
import br.com.gerenciamento.repository.SemafaroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/semafaro")
public class SemafaroController {

    @Autowired
    private SemafaroRepository semafaroRepository;

    // Endpoint para listar todos os semáfaros
    @GetMapping
    public ResponseEntity<List<Semafaro>> listarTodos() {
        List<Semafaro> semaforos = semafaroRepository.findAll();
        return ResponseEntity.ok(semaforos);
    }

    // Endpoint para buscar um semáfaro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Semafaro> buscarPorId(@PathVariable Long id) {
        Optional<Semafaro> semafaro = semafaroRepository.findById(id);
        return semafaro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo semáfaro
    @PostMapping
    public ResponseEntity<Semafaro> criar(@RequestBody Semafaro semafaro) {
        Semafaro novoSemafaro = semafaroRepository.save(semafaro);
        novoSemafaro.getId();
        return ResponseEntity.status(HttpStatus.CREATED).body(novoSemafaro);
    }

    // Endpoint para atualizar um semáfaro existente
    @PutMapping("/{id}")
    public ResponseEntity<Semafaro> atualizar(@PathVariable Long id, @RequestBody Semafaro semafaroAtualizado) {
        return semafaroRepository.findById(id)
                .map(semafaro -> {
                    semafaro.setRua(semafaroAtualizado.getRua()); // Usando getRua()
                    semafaro.setNumero(semafaroAtualizado.getNumero()); // Usando getNumero()
                    semafaro.setCep(semafaroAtualizado.getCep());
                    Semafaro semafaroSalvo = semafaroRepository.save(semafaro);
                    return ResponseEntity.ok(semafaroSalvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para excluir um semáfaro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (semafaroRepository.existsById(id)) {
            semafaroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
