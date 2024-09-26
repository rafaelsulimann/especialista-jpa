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

public class MapeandoOneToManyTest extends EntityManagerTest {

    @Test
    public void buscarPedidosCliente() {
        Cliente cliente = super.entityManager.find(Cliente.class, 1L);
        Assertions.assertNotNull(cliente);

        Pedido pedido = new Pedido(
            LocalDateTime.now(),
            StatusPedido.AGUARDANDO,
            new BigDecimal(1000),
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

        Pedido pedido2 = new Pedido(
            LocalDateTime.now(),
            StatusPedido.AGUARDANDO,
            new BigDecimal(1500),
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
        super.entityManager.persist(pedido2);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Cliente clienteVerificacao = super.entityManager.find(Cliente.class, 1L);
        System.out.println(clienteVerificacao);
        Assertions.assertNotNull(clienteVerificacao);

        Assertions.assertFalse(clienteVerificacao.getPedidos().isEmpty());
        System.out.println("Pedidos:");
        clienteVerificacao.getPedidos().forEach(System.out::println);
    }

    @Test
    public void buscarItensPedidoDoPedido() {
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

        ItemPedido itemPedido2 = new ItemPedido(
            pedido,
            produto,
            produto.getPreco(),
            20
        );

        ItemPedido itemPedido3 = new ItemPedido(
            pedido,
            produto,
            produto.getPreco(),
            30
        );

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(pedido);
        super.entityManager.persist(itemPedido);
        super.entityManager.persist(itemPedido2);
        super.entityManager.persist(itemPedido3);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Pedido pedidoVerificacao = super.entityManager.find(Pedido.class, 1L);
        Assertions.assertNotNull(pedidoVerificacao);

        System.out.println(pedidoVerificacao);
        Assertions.assertFalse(pedidoVerificacao.getItens().isEmpty());
        pedidoVerificacao.getItens().forEach(System.out::println);
    }

    @Test
    public void buscarItensPedidoQueProdutoPertence() {
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

        ItemPedido itemPedido2 = new ItemPedido(
            pedido,
            produto,
            produto.getPreco(),
            20
        );

        ItemPedido itemPedido3 = new ItemPedido(
            pedido,
            produto,
            produto.getPreco(),
            30
        );

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(pedido);
        super.entityManager.persist(itemPedido);
        super.entityManager.persist(itemPedido2);
        super.entityManager.persist(itemPedido3);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Produto produtoVerificacao = super.entityManager.find(Produto.class, produto.getId());
        Assertions.assertNotNull(produtoVerificacao);

        System.out.println(produtoVerificacao);
        Assertions.assertFalse(produtoVerificacao.getItens().isEmpty());
        produtoVerificacao.getItens().forEach(System.out::println);
    }

}
