package com.sulimann.iniciandocomjpa.inicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class BuscandoPorIdTest extends EntityManagerTest{

  @Test
  public void buscarPorIdComFind() {
    Produto produto = super.entityManager.find(Produto.class, 1L);
    System.out.println("Já executou o select no banco de dados");
    System.out.println(produto);
    Assertions.assertNotNull(produto);
    Assertions.assertEquals("Notebook", produto.getNome());
  }

  @Test
  public void buscarPorIdComGetReference() {
    Produto produto = super.entityManager.getReference(Produto.class, 1L);
    Assertions.assertNotNull(produto);
    System.out.println("Ainda não foi executado o select no banco de dados");
    System.out.println(produto);
    Assertions.assertEquals("Notebook", produto.getNome());
  }

  @Test
  public void buscarPorIdComFindERefresh(){
    Produto produto = super.entityManager.find(Produto.class, 1L);
    System.out.println("Já executou o select no banco de dados");
    System.out.println(produto);
    produto.setNome("Não vai ser atualizado por causa do Refresh");
    super.entityManager.refresh(produto);
    System.out.println("Executou o select novamente no banco de dados e voltou os dados no contexto como estavam no banco de dados");
    System.out.println(produto);
    Assertions.assertNotNull(produto);
    Assertions.assertEquals("Notebook", produto.getNome());
  }
}
