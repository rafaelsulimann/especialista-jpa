package com.sulimann.iniciandocomjpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "categoriasFilhas")
@Entity
@Table(name = "categoria")
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;

  @ManyToOne
  @JoinColumn(name = "categoria_pai_id")
  private Categoria categoriaPai;

  @OneToMany(mappedBy = "categoriaPai")
  private List<Categoria> categoriasFilhas;
}
