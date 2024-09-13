package com.sulimann.iniciandocomjpa.mapeandorelacionamento;

import com.sulimann.iniciandocomjpa.entities.*;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeandoManyToOneTest extends EntityManagerTest {

    @Test
    public void inserirPedidoComCliente(){
        Cliente cliente = super.entityManager.find(Cliente.class, 1L);
        Assertions.assertNotNull(cliente);

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(new BigDecimal(1000));
        pedido.setNotaFiscalId(2L);
        pedido.setEnderecoEntrega(new EnderecoEntregaPedido(
                "38400-000",
                "Rua das Laranjeiras",
                "123",
                "Bairro Qualquer",
                "Apto 303",
                "Uberlândia",
                "MG"
        ));

        pedido.setCliente(cliente);

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

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(new BigDecimal(1000));
        pedido.setNotaFiscalId(2L);
        pedido.setEnderecoEntrega(new EnderecoEntregaPedido(
                "38400-000",
                "Rua das Laranjeiras",
                "123",
                "Bairro Qualquer",
                "Apto 303",
                "Uberlândia",
                "MG"
        ));

        pedido.setCliente(cliente);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(10);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

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
