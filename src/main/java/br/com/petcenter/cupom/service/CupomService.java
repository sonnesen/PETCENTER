package br.com.petcenter.cupom.service;

import br.com.petcenter.cupom.controller.request.CupomRequest;
import br.com.petcenter.cupom.infraestructure.CupomRepository;
import br.com.petcenter.cupom.model.Cupom;
import br.com.petcenter.cupom.model.dto.CupomDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CupomService{
	
	private final CupomRepository cupomRepository;
	
	public CupomService(CupomRepository cupomRepository) {
		this.cupomRepository = cupomRepository;
	}

	public CupomDTO aplicarCupom(CupomRequest request){
		
		Optional<Cupom> cupom = cupomRepository.findById(request.getCupom());
		
		if(cupom.isEmpty()){
			return new CupomDTO(
					false, //cumpomValido
					request.getValorTotal() //valorTotal
			);
			
		}

		Cupom cupomModel = cupom.get();

		if(cupomModel.getNumeroUsos() >= cupomModel.getNumeroMaximoUsos()) {
			return new CupomDTO(
					false, //cumpomValido
					request.getValorTotal() //valorTotal
			);
		}

		cupomModel.setNumeroUsos(cupomModel.getNumeroUsos() + 1);
		
		cupomRepository.save(cupomModel);
		
		//Calculando o desconto 
		BigDecimal porcentagemDesconto = BigDecimal.valueOf(cupomModel.getPorcentagemDesconto() / 100.0);
		
		BigDecimal desconto = request.getValorTotal().multiply(porcentagemDesconto);

		BigDecimal valorTotal = request.getValorTotal().subtract(desconto);
		
		CupomDTO cupomDTO = new CupomDTO(
				true, //cumpomValido
				valorTotal //valorTotal
		);
		
		return cupomDTO;
	}

}
