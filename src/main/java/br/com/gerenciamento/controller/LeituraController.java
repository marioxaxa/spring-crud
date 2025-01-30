package br.com.gerenciamento.controller;

import br.com.gerenciamento.model.Leitura;
import br.com.gerenciamento.service.LeituraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leituras") // Define o endpoint base para o controller
public class LeituraController {

    @Autowired
    private LeituraService leituraService; // Injeção de dependência do serviço

    // Endpoint para criar uma nova leitura
    @PostMapping
    public ResponseEntity<Leitura> criarLeitura(@RequestBody Leitura leitura) {
        Leitura novaLeitura = leituraService.salvarLeitura(leitura);
        return new ResponseEntity<>(novaLeitura, HttpStatus.CREATED);
    }

    // Endpoint para buscar todas as leituras
    @GetMapping
    public ResponseEntity<List<Leitura>> listarLeituras() {
        List<Leitura> leituras = leituraService.listarTodasLeituras();
        return new ResponseEntity<>(leituras, HttpStatus.OK);
    }

    // Endpoint para buscar uma leitura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Leitura> buscarLeituraPorId(@PathVariable Long id) {
        Leitura leitura = leituraService.buscarLeituraPorId(id);
        return leitura != null
                ? new ResponseEntity<>(leitura, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para atualizar uma leitura existente
    @PutMapping("/{id}")
    public ResponseEntity<Leitura> atualizarLeitura(@PathVariable Long id, @RequestBody Leitura leituraAtualizada) {
        Leitura leitura = leituraService.atualizarLeitura(id, leituraAtualizada);
        return leitura != null
                ? new ResponseEntity<>(leitura, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para deletar uma leitura por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLeitura(@PathVariable Long id) {
        boolean deletado = leituraService.deletarLeitura(id);
        return deletado
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}