package com.sulimann.iniciandocomjpa.entities;

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
@Table(name = "pagamento_boleto")
public class PagamentoBoleto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "pedido_id")
  private Long pedidoId;

  @Enumerated(EnumType.STRING)
  private StatusPagamento status;

  @Column(name = "codigo_barras")
  private String codigoBarras;

}
