package com.sulimann.iniciandocomjpa.conhecendoentitymanager;

import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class EntendendoCacheDePrimeiroNivel extends EntityManagerTest {

  @Test
  public void cacheDePrimeiroNivel(){
    Produto produto = super.entityManager.find(Produto.class, 1L);
    System.out.println(produto);
    System.out.println("---------------------------");

    Produto produtoCache = super.entityManager.find(Produto.class, produto.getId());
    System.out.println(produtoCache);
  }

}
