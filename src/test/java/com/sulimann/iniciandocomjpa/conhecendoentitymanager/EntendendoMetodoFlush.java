package com.sulimann.iniciandocomjpa.conhecendoentitymanager;

import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.entities.StatusPedido;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class EntendendoMetodoFlush extends EntityManagerTest {

  @Test
  public void flushAntesDoClear() {
    super.entityManager.getTransaction().begin();
    Pedido pedido = super.entityManager.find(Pedido.class, 1L);
    System.out.println(pedido);
    pedido.setStatus(StatusPedido.PAGO);
    System.out.println(pedido);

    super.entityManager.flush();
    super.entityManager.clear();

    Pedido pedidoAtualizado = super.entityManager.find(Pedido.class, 1L);
    System.out.println(pedidoAtualizado);

    System.out.println("---------------------");
    System.out.println("AINDA NÃO EXECUTOU O COMMIT MAS O PEDIDO JA FOI ATUALIZADO NO BANCO DE DADOS!");
    System.out.println("---------------------");

    super.entityManager.getTransaction().commit();
  }

  @Test
  public void flushComJpql() {
    super.entityManager.getTransaction().begin();

    Pedido pedido = super.entityManager.find(Pedido.class, 1L);
    System.out.println(pedido);

    pedido.setStatus(StatusPedido.PAGO);
    System.out.println(pedido);

    Pedido pedidoJpql = super.entityManager.createQuery("SELECT p FROM Pedido p WHERE p.id = 1", Pedido.class)
        .getSingleResult();
    System.out.println(pedidoJpql);

    System.out.println("---------------------");
    System.out.println("AINDA NÃO EXECUTOU O COMMIT MAS O PEDIDO JA FOI ATUALIZADO NO BANCO DE DADOS!");
    System.out.println("---------------------");

    super.entityManager.getTransaction().commit();
  }

}
