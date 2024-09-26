package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString
@Embeddable
public class EnderecoEntregaPedido {

    @NonNull
    @Column(name = "cep")
    private String cep;

    @NonNull
    @Column(name = "logradouro")
    private String logradouro;

    @NonNull
    @Column(name = "numero")
    private String numero;

    @NonNull
    @Column(name = "bairro")
    private String bairro;

    @Column(name = "complemento")
    private String complemento;

    @NonNull
    @Column(name = "cidade")
    private String cidade;

    @NonNull
    @Column(name = "estado")
    private String estado;

}
