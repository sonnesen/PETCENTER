package br.com.petcenter.cupom.service;

import br.com.petcenter.cupom.controller.request.CupomRequest;
import br.com.petcenter.cupom.model.dto.CupomDTO;

public interface CupomService {
    CupomDTO aplicarCupom(CupomRequest request);
}
