package com.sulimann.iniciandocomjpa.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @Column(name = "preco_produto")
  private BigDecimal precoProduto;

  private Integer quantidade;

}
