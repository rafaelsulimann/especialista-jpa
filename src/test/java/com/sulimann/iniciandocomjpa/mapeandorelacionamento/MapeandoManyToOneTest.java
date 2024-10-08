package com.sulimann.iniciandocomjpa.mapeandorelacionamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Cliente;
import com.sulimann.iniciandocomjpa.entities.EnderecoEntregaPedido;
import com.sulimann.iniciandocomjpa.entities.ItemPedido;
import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.entities.StatusPedido;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class MapeandoManyToOneTest extends EntityManagerTest {

    @Test
    public void inserirPedidoComCliente(){
        Cliente cliente = super.entityManager.find(Cliente.class, 1L);
        Assertions.assertNotNull(cliente);

        Pedido pedido = new Pedido(
            LocalDateTime.now(),
            StatusPedido.AGUARDANDO,
            new BigDecimal("1000.00"),
            new EnderecoEntregaPedido(
                "92410-720",
                "Rua Xingu",
                "315",
                "Igara",
                "Canoas",
                "RS"
            ),
            cliente
        );

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(pedido);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Pedido pedidoVerificacao = super.entityManager.find(Pedido.class, pedido.getId());
        System.out.println(pedidoVerificacao);
        System.out.println(pedidoVerificacao.getCliente());
        Assertions.assertNotNull(pedidoVerificacao);
        Assertions.assertNotNull(pedidoVerificacao.getCliente());
    }

    @Test
    public void inserirItensComPedidoEProduto(){
        Produto produto = super.entityManager.find(Produto.class, 1L);
        Cliente cliente = super.entityManager.find(Cliente.class, 1L);
        Assertions.assertNotNull(produto);
        Assertions.assertNotNull(cliente);

        Pedido pedido = new Pedido(
            LocalDateTime.now(),
            StatusPedido.AGUARDANDO,
            new BigDecimal("1000.00"),
            new EnderecoEntregaPedido(
                "92410-720",
                "Rua Xingu",
                "315",
                "Igara",
                "Canoas",
                "RS"
            ),
            cliente
        );

        ItemPedido itemPedido = new ItemPedido(
            pedido,
            produto,
            produto.getPreco(),
            10
        );

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(pedido);
        super.entityManager.persist(itemPedido);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        ItemPedido itemPedidoVerificacao = super.entityManager.find(ItemPedido.class, itemPedido.getId());
        Assertions.assertNotNull(itemPedidoVerificacao);
        Assertions.assertNotNull(itemPedidoVerificacao.getPedido());
        Assertions.assertNotNull(itemPedidoVerificacao.getProduto());

        System.out.println(itemPedidoVerificacao);
        System.out.println(itemPedidoVerificacao.getPedido());
        System.out.println(itemPedidoVerificacao.getProduto());

    }
}
