package com.sulimann.iniciandocomjpa.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;

  @Column(name = "data_ultima_atualizacao")
  private LocalDateTime dataUltimaAtualizacao;

  @PrePersist
  public void antesDePersistir(){
    this.dataCriacao = LocalDateTime.now();
  }

  @PreUpdate
  public void antesDeAtualizar(){
    this.dataUltimaAtualizacao = LocalDateTime.now();
  }

  @PreRemove
  public void antesDeRemover(){
    System.out.println("Antes de remover...");
  }

  @PostPersist
  public void aposPersistir(){
    System.out.println("Após persistir...");
  }

  @PostUpdate
  public void aposAtualizar(){
    System.out.println("Após atualizar....");
  }

  @PostRemove
  public void aposRemover(){
    System.out.println("Após remover...");
  }

  @PostLoad
  public void aposObter(){
    System.out.println("Após obter...");
  }

}
