package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "itens")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String descricao;
  private BigDecimal preco;

  @OneToMany(mappedBy = "produto")
  private List<ItemPedido> itens;

}
