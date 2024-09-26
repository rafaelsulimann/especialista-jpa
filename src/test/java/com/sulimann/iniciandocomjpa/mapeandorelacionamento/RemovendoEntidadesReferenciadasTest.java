package com.sulimann.iniciandocomjpa.mapeandorelacionamento;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class RemovendoEntidadesReferenciadasTest extends EntityManagerTest {

  @Test
  public void removerEntidadeRelacionada() {
    Pedido pedido = entityManager.find(Pedido.class, 1L);
    Assertions.assertNotNull(pedido);
    Assertions.assertFalse(pedido.getItens().isEmpty());
    System.out.println(pedido);
    pedido.getItens().forEach(System.out::println);

    super.entityManager.getTransaction().begin();
    pedido.getItens().forEach(entityManager::remove);
    super.entityManager.remove(pedido);
    super.entityManager.getTransaction().commit();

    super.entityManager.clear();

    Pedido pedidoVerificacao = entityManager.find(Pedido.class, 1L);
    Assertions.assertNull(pedidoVerificacao);
  }

}
