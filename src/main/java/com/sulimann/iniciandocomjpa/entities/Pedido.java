package com.sulimann.iniciandocomjpa.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString(exclude = {"itens", "pagamentoCartao", "notaFiscal"})
@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @Column(name = "data_pedido")
  private LocalDateTime dataPedido;

  @Column(name = "data_conclusao")
  private LocalDateTime dataConclusao;

  @NonNull
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private StatusPedido status;

  @NonNull
  @Column(name = "total")
  private BigDecimal total;

  @NonNull
  @Embedded
  private EnderecoEntregaPedido enderecoEntrega;

  @NonNull
  @ManyToOne(optional = false)
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  @OneToMany(mappedBy = "pedido")
  private List<ItemPedido> itens;

  @OneToOne(mappedBy = "pedido")
  private PagamentoCartao pagamentoCartao;

  @OneToOne(mappedBy = "pedido")
  private NotaFiscal notaFiscal;

}
