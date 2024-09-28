package com.sulimann.iniciandocomjpa.mapeandorelacionamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Cliente;
import com.sulimann.iniciandocomjpa.entities.EnderecoEntregaPedido;
import com.sulimann.iniciandocomjpa.entities.Estoque;
import com.sulimann.iniciandocomjpa.entities.ItemPedido;
import com.sulimann.iniciandocomjpa.entities.NotaFiscal;
import com.sulimann.iniciandocomjpa.entities.PagamentoCartao;
import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.entities.StatusPagamento;
import com.sulimann.iniciandocomjpa.entities.StatusPedido;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class OptionalTest extends EntityManagerTest {

  @Test
  public void verificarOptionalInPedidoWithCliente() {
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
  }

  @Test
  public void verificarOptionalInEstoqueWithProduto(){
    Produto produto = super.entityManager.find(Produto.class, 1L);
    Assertions.assertNotNull(produto);

    Estoque estoque = new Estoque(produto, 30);

    super.entityManager.getTransaction().begin();
    super.entityManager.persist(estoque);
    super.entityManager.getTransaction().commit();

    super.entityManager.clear();

    Estoque estoqueVerificacao = super.entityManager.find(Estoque.class, estoque.getId());
    System.out.println(estoqueVerificacao);
    Assertions.assertNotNull(estoqueVerificacao);
  }

  @Test
  public void verificarOptionalInItemPedidoWithPedidoAndProduto(){
    Produto produto = super.entityManager.find(Produto.class, 1L);
    Assertions.assertNotNull(produto);

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
    System.out.println(itemPedidoVerificacao);
    Assertions.assertNotNull(itemPedidoVerificacao);
  }

  @Test
  public void verificarOptionalInNotaFiscalWithPedido(){
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

    NotaFiscal notaFiscal = new NotaFiscal(
      pedido,
      "XML TESTE!",
      LocalDateTime.now()
    );

    super.entityManager.getTransaction().begin();
    super.entityManager.persist(pedido);
    super.entityManager.persist(notaFiscal);
    super.entityManager.getTransaction().commit();

    super.entityManager.clear();

    NotaFiscal notaFiscalVerificacao = super.entityManager.find(NotaFiscal.class, notaFiscal.getId());
    System.out.println(notaFiscalVerificacao);
    Assertions.assertNotNull(notaFiscalVerificacao);
  }

  @Test
  public void verificarOptionalInPagamentoCartaoWithPedido(){
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

    PagamentoCartao pagamentoCartao = new PagamentoCartao(
      pedido,
      StatusPagamento.PROCESSANDO,
      "1234"
    );

    super.entityManager.getTransaction().begin();
    super.entityManager.persist(pedido);
    super.entityManager.persist(pagamentoCartao);
    super.entityManager.getTransaction().commit();

    super.entityManager.clear();

    PagamentoCartao pagamentoCartaoVerificacao = super.entityManager.find(PagamentoCartao.class, pagamentoCartao.getId());
    System.out.println(pagamentoCartaoVerificacao);
    Assertions.assertNotNull(pagamentoCartaoVerificacao);
  }

}
