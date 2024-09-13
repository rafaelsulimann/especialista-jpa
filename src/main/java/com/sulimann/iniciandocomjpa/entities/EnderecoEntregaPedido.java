package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class EnderecoEntregaPedido {

    @Column(name = "cep")
    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;

}
