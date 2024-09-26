package com.sulimann.iniciandocomjpa.mapeandorelacionamento;

import com.sulimann.iniciandocomjpa.entities.ItemPedido;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

import java.util.List;

public class EagerELazyTest extends EntityManagerTest{

  @Test
  public void verificarComportamento(){
    Pedido pedido = super.entityManager.find(Pedido.class, 1L);
    List<ItemPedido> itens = pedido.getItens();
    itens.forEach(System.out::println);
  }
}
