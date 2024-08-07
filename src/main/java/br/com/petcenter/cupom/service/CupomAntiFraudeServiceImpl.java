package br.com.petcenter.cupom.service;

import br.com.petcenter.cupom.infraestructure.CupomRepository;
import br.com.petcenter.cupom.model.Cupom;
import br.com.petcenter.cupom.service.exceptions.CupomInvalido;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CupomAntiFraudeServiceImpl implements CupomAntiFraudeService{

    private final CupomRepository cupomRepository;

    public CupomAntiFraudeServiceImpl(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    @Override
    public Cupom validaCupom(String id) {
        Optional<Cupom> cupom = cupomRepository.findById(id);

        if(cupom.isEmpty()){
            throw new CupomInvalido("Cupom inexistente");
        }

        Cupom cupomModel = cupom.get();

        if(cupomModel.getNumeroUsos() >= cupomModel.getNumeroMaximoUsos()) {
            throw new CupomInvalido("Cupom inválido");
        }
        return cupomModel;
    }
}
