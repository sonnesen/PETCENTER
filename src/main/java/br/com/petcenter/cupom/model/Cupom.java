package br.com.petcenter.cupom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cupom {
	@Id
	private String cupom;
	private int numeroMaximoUsos;
	private int numeroUsos;
	private int porcentagemDesconto;

}
