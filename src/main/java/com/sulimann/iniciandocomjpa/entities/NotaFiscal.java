package com.sulimann.iniciandocomjpa.entities;

import java.util.Date;

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
@Table(name = "nota_fiscal")
public class NotaFiscal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "pedido_id")
  private Long pedidoId;

  private String xml;

  @Column(name = "data_emissao")
  private Date dataEmissao;

}
