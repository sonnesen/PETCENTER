package br.com.petcenter.cupom.controller.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CupomRequest {
	private String cupom;
	private BigDecimal valorTotal;

	public CupomRequest(String cupom, BigDecimal valorTotal) {
		this.cupom = cupom;
		this.valorTotal = valorTotal;
	}
}
