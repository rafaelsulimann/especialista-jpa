package com.sulimann.iniciandocomjpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @JoinColumn(name = "pedido_id")
  @OneToOne(optional = false)
  private Pedido pedido;

  @NonNull
  @Column(name = "xml")
  private String xml;

  @NonNull
  @Column(name = "data_emissao")
  private LocalDateTime dataEmissao;

}
