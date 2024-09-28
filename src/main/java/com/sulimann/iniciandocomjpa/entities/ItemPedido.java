package com.sulimann.iniciandocomjpa.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "item_pedido")
public class ItemPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @NonNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @NonNull
  @Column(name = "preco_produto")
  private BigDecimal precoProduto;

  @NonNull
  @Column(name = "quantidade")
  private Integer quantidade;

}
