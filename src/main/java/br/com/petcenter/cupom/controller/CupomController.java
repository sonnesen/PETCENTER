package br.com.petcenter.cupom.controller;

import br.com.petcenter.cupom.controller.request.CupomRequest;
import br.com.petcenter.cupom.model.dto.CupomDTO;
import br.com.petcenter.cupom.service.CupomService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CupomController {
	
	private final CupomService cupomServiceImpl;
	
	public CupomController(CupomService cupomService) {
		this.cupomServiceImpl = cupomService;
	}
	
	@SuppressWarnings("rawtypes")
	@PutMapping(
			value = "/cupom/{cupom}/{valorTotal}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity aplicarCupom(
			@PathVariable("cupom") String cupom,
			@PathVariable("valorTotal") BigDecimal valorTotal) throws Exception{

		CupomRequest request = new CupomRequest(cupom, valorTotal);
		
		validaRequisicao(request);
		
		CupomDTO cupomDTO = cupomServiceImpl.aplicarCupom(request);
		
		return cupomDTO.getCumpomValido() ? 
				ResponseEntity.ok().body(cupomDTO) :
				ResponseEntity.badRequest().body(cupomDTO);
	}
	
	private void validaRequisicao(CupomRequest request) throws Exception {
		if(request.getCupom() == null || request.getCupom() == "") {
			throw new Exception("Campo obrigatório: cupom");
			
		}else if(request.getValorTotal() == null) {
			throw new Exception("Campo obrigatório: valorTotal");
		}
	}
}
