package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "pedidos")
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private SexoCliente sexo;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
