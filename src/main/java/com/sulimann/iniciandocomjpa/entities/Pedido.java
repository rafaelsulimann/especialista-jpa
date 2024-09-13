package com.sulimann.iniciandocomjpa.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "itens")
@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "data_pedido")
  private LocalDateTime dataPedido;

  @Column(name = "data_conclusao")
  private LocalDateTime dataConclusao;

  @Column(name = "nota_fiscal_id")
  private Long notaFiscalId;

  @Enumerated(EnumType.STRING)
  private StatusPedido status;

  private BigDecimal total;

  @Embedded
  private EnderecoEntregaPedido enderecoEntrega;

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @OneToMany(mappedBy = "pedido")
  private List<ItemPedido> itens;

}
