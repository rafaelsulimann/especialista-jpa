package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor(onConstructor_ = @Deprecated)
@RequiredArgsConstructor
@ToString(exclude = {"categoriasFilhas", "produtos"})
@Entity
@Table(name = "categoria")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  @Column(name = "nome")
  private String nome;

  @ManyToOne
  @JoinColumn(name = "categoria_pai_id")
  private Categoria categoriaPai;

  @OneToMany(mappedBy = "categoriaPai")
  private List<Categoria> categoriasFilhas;

  @ManyToMany(mappedBy = "categorias")
  private List<Produto> produtos;
}
