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
                "MG"));
        pedido.setCliente(cliente);

        Pedido pedido2 = new Pedido();
        pedido2.setStatus(StatusPedido.AGUARDANDO);
        pedido2.setDataPedido(LocalDateTime.now());
        pedido2.setTotal(new BigDecimal(1500));
        pedido2.setNotaFiscalId(3L);
        pedido2.setEnderecoEntrega(new EnderecoEntregaPedido(
                "38400-000",
                "Rua das Laranjeiras",
                "123",
                "Bairro Qualquer",
                "Apto 303",
                "Uberlândia",
                "MG"));
        pedido2.setCliente(cliente);

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

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(new BigDecimal(1000));
        pedido.setNotaFiscalId(2L);
        pedido.setCliente(cliente);
        pedido.setEnderecoEntrega(new EnderecoEntregaPedido(
                "38400-000",
                "Rua das Laranjeiras",
                "123",
                "Bairro Qualquer",
                "Apto 303",
                "Uberlândia",
                "MG"));

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(10);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        ItemPedido itemPedido2 = new ItemPedido();
        itemPedido2.setPrecoProduto(produto.getPreco());
        itemPedido2.setQuantidade(20);
        itemPedido2.setPedido(pedido);
        itemPedido2.setProduto(produto);

        ItemPedido itemPedido3 = new ItemPedido();
        itemPedido3.setPrecoProduto(produto.getPreco());
        itemPedido3.setQuantidade(30);
        itemPedido3.setPedido(pedido);
        itemPedido3.setProduto(produto);

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

        Pedido pedido = new Pedido();
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(new BigDecimal(1000));
        pedido.setNotaFiscalId(2L);
        pedido.setCliente(cliente);
        pedido.setEnderecoEntrega(new EnderecoEntregaPedido(
                "38400-000",
                "Rua das Laranjeiras",
                "123",
                "Bairro Qualquer",
                "Apto 303",
                "Uberlândia",
                "MG"));

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(produto.getPreco());
        itemPedido.setQuantidade(10);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        ItemPedido itemPedido2 = new ItemPedido();
        itemPedido2.setPrecoProduto(produto.getPreco());
        itemPedido2.setQuantidade(20);
        itemPedido2.setPedido(pedido);
        itemPedido2.setProduto(produto);

        ItemPedido itemPedido3 = new ItemPedido();
        itemPedido3.setPrecoProduto(produto.getPreco());
        itemPedido3.setQuantidade(30);
        itemPedido3.setPedido(pedido);
        itemPedido3.setProduto(produto);

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
