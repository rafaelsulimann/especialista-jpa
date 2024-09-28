package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "estoque")
public class Estoque {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @JoinColumn(name = "produto_id")
  @OneToOne(optional = false)
  private Produto produto;

  @NonNull
  @Column(name = "quantidade")
  private Integer quantidade;

}
