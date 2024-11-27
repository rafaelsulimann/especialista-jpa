package com.sulimann.iniciandocomjpa.conhecendoentitymanager;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class ContextoDePersistenciaEDirtyChecking extends EntityManagerTest {

  @Test
  public void contextoPersistenciaEDirtyChecking(){
    super.entityManager.getTransaction().begin();

    Produto produto = super.entityManager.find(Produto.class, 1L);
    produto.setNome("Contexto de persistência com FIND");
    super.entityManager.merge(produto);

    Produto produto2 = new Produto("Contexto de persistência com PERSIST", "PERSIST", new BigDecimal(100.0));
    super.entityManager.persist(produto2);

    Produto produto3 = new Produto("Contexto de persistência com MERGE", "MERGE", new BigDecimal(100.0));
    produto3 = super.entityManager.merge(produto3);

    System.out.println("---------------------");
    System.out.println("AINDA NÃO EXECUTOU O COMMIT!");
    System.out.println("---------------------");

    super.entityManager.getTransaction().commit();
  }

}
