package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @OneToOne
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @NonNull
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private StatusPagamento status;

  @NonNull
  @Column(name = "numero_cartao")
  private String numeroCartao;

}
