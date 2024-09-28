package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString(exclude = {"itens", "categorias", "estoque"})
@Getter
@Setter
@Entity
@Table(name = "produto")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @Column(name = "nome")
  private String nome;

  @NonNull
  @Column(name = "descricao")
  private String descricao;

  @NonNull
  @Column(name = "preco")
  private BigDecimal preco;

  @OneToMany(mappedBy = "produto")
  private List<ItemPedido> itens;

  @ManyToMany
  @JoinTable(name = "produtos_categorias",
      joinColumns = @JoinColumn(name = "produto_id"),
      inverseJoinColumns = @JoinColumn(name = "categoria_id"))
  private List<Categoria> categorias;

  @OneToOne(mappedBy = "produto")
  private Estoque estoque;

}
