package br.com.gerenciamento.service;

import br.com.gerenciamento.model.Leitura;
import br.com.gerenciamento.repository.LeituraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeituraService {

    @Autowired
    private LeituraRepository leituraRepository;

    // Salva uma nova leitura
    public Leitura salvarLeitura(Leitura leitura) {
        return leituraRepository.save(leitura);
    }

    // Lista todas as leituras
    public List<Leitura> listarTodasLeituras() {
        return leituraRepository.findAll();
    }

    // Busca uma leitura por ID
    public Leitura buscarLeituraPorId(Long id) {
        Optional<Leitura> leitura = leituraRepository.findById(id);
        return leitura.orElse(null);
    }

    // Atualiza uma leitura existente
    public Leitura atualizarLeitura(Long id, Leitura leituraAtualizada) {
        Optional<Leitura> leituraExistente = leituraRepository.findById(id);
        if (leituraExistente.isPresent()) {
            Leitura leitura = leituraExistente.get();
            leitura.setDateTime(leituraAtualizada.getDateTime());
            leitura.setSemafaro(leituraAtualizada.getSemafaro());
            leitura.setTemperatura(leituraAtualizada.getTemperatura());
            leitura.setChuva(leituraAtualizada.getChuva());
            leitura.setRuido(leituraAtualizada.getRuido());
            return leituraRepository.save(leitura);
        }
        return null;
    }

    // Deleta uma leitura por ID
    public boolean deletarLeitura(Long id) {
        if (leituraRepository.existsById(id)) {
            leituraRepository.deleteById(id);
            return true;
        }
        return false;
    }
}