package br.com.petcenter.pedido.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Produto {

    @Id
    private Long ean;
    private String nome;
    private Long quantidade;

}
