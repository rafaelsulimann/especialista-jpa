package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString(exclude = "pedidos")
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "nome")
    private String nome;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private SexoCliente sexo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
