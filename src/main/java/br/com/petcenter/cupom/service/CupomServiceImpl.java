package br.com.petcenter.cupom.service;

import br.com.petcenter.cupom.controller.request.CupomRequest;
import br.com.petcenter.cupom.infraestructure.CupomRepository;
import br.com.petcenter.cupom.model.Cupom;
import br.com.petcenter.cupom.model.dto.CupomDTO;
import br.com.petcenter.cupom.service.exceptions.CupomInvalido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class CupomServiceImpl implements CupomService {
	
	private final CupomRepository cupomRepository;
	private final CupomAntiFraudeService cupomAntiFraudeService;
	
	public CupomServiceImpl(CupomRepository cupomRepository, CupomAntiFraudeService cupomAntiFraudeService) {
		this.cupomRepository = cupomRepository;
		this.cupomAntiFraudeService = cupomAntiFraudeService;
	}

	@Override
	public CupomDTO aplicarCupom(CupomRequest request){
		Cupom cupom;
		try {
			cupom = cupomAntiFraudeService.validaCupom(request.getCupom());
		} catch (CupomInvalido ex) {
			log.warn("Cupom inválido %s".formatted(request.getCupom()));
			return new CupomDTO(
					false, //cumpomValido
					request.getValorTotal() //valorTotal
			);
		}
		cupom.setNumeroUsos(cupom.getNumeroUsos() + 1);
		cupomRepository.save(cupom);

		//Calculando o desconto 
		BigDecimal porcentagemDesconto = BigDecimal.valueOf(cupom.getPorcentagemDesconto() / 100.0);
		BigDecimal desconto = request.getValorTotal().multiply(porcentagemDesconto);
		BigDecimal valorTotal = request.getValorTotal().subtract(desconto);
		CupomDTO cupomDTO = new CupomDTO(
				true, //cumpomValido
				valorTotal //valorTotal
		);
		
		return cupomDTO;
	}

}
