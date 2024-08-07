package br.com.petcenter.cupom.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CupomDTO {
	private Boolean cumpomValido;
	private BigDecimal valorTotal;

	public CupomDTO(Boolean cumpomValido, BigDecimal valorTotal) {
		this.cumpomValido = cumpomValido;
		this.valorTotal = valorTotal;
	}
}
