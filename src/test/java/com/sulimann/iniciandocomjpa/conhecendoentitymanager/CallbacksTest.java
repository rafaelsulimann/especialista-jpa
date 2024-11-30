package com.sulimann.iniciandocomjpa.conhecendoentitymanager;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class CallbacksTest extends EntityManagerTest{

  @Test
  public void testandoCallbacks(){
    super.entityManager.getTransaction().begin();
    Produto produto = new Produto("Callbacks test", "CALLBACKS", new BigDecimal(100.0));
    super.entityManager.persist(produto);
    super.entityManager.clear();

    Produto produtoAtualizado = super.entityManager.find(Produto.class, produto.getId());
    System.out.println(produtoAtualizado);
    produtoAtualizado.setNome("Callback @PreUpdate test");

    super.entityManager.getTransaction().commit();

    super.entityManager.clear();

    Produto produtoCompleto = super.entityManager.find(Produto.class, produto.getId());
    System.out.println(produtoCompleto);
    Assertions.assertNotNull(produtoCompleto.getDataCriacao());
    Assertions.assertNotNull(produtoCompleto.getDataUltimaAtualizacao());
  }

}
