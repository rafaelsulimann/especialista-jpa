package com.sulimann.iniciandocomjpa.conhecendoentitymanager;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.entities.StatusPedido;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class GerenciandoTransacoes extends EntityManagerTest {

  @Test
  public void abrindoEFechandoTransacao() {
    super.entityManager.getTransaction().begin(); // ABRINDO TRANSACAO
    // REGRA DE NEGÓCIO
    super.entityManager.getTransaction().commit(); // FECHANDO TRANSACAO
  }

  @Test
  public void verificandoExcecao(){
    Assertions.assertThrows(Exception.class, () -> {
      this.acionandoRollback();
    });
  }

  private void acionandoRollback() {
    try {
      super.entityManager.getTransaction().begin();
      this.regraDeNegocio();
      super.entityManager.getTransaction().commit();
    } catch (Exception e) {
      super.entityManager.getTransaction().rollback();
      Pedido pedido = super.entityManager.find(Pedido.class, 1L);
      System.out.println(pedido);
      throw e;
    }
  }

  private void regraDeNegocio() {
    Pedido pedido = super.entityManager.find(Pedido.class, 1L);
    System.out.println(pedido);
    pedido.setStatus(StatusPedido.PAGO);
    System.out.println(pedido);

    if(pedido.getPagamentoCartao() == null){
      throw new RuntimeException("Pagamento ainda não foi realizado");
    }
  }

}
