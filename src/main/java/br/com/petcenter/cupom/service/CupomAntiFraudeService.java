package br.com.petcenter.cupom.service;

import br.com.petcenter.cupom.model.Cupom;
import br.com.petcenter.cupom.service.exceptions.CupomInvalido;

public interface CupomAntiFraudeService {
    Cupom validaCupom(String id) throws CupomInvalido;
}
