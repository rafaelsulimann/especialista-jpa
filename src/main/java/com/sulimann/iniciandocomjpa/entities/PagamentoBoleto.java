package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "pagamento_boleto")
public class PagamentoBoleto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @Column(name = "pedido_id")
  private Long pedidoId;

  @NonNull
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private StatusPagamento status;

  @NonNull
  @Column(name = "codigo_barras")
  private String codigoBarras;

}
