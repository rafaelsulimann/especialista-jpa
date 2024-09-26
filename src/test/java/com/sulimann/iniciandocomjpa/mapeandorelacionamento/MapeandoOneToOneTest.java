package com.sulimann.iniciandocomjpa.mapeandorelacionamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Cliente;
import com.sulimann.iniciandocomjpa.entities.EnderecoEntregaPedido;
import com.sulimann.iniciandocomjpa.entities.NotaFiscal;
import com.sulimann.iniciandocomjpa.entities.PagamentoCartao;
import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.entities.StatusPagamento;
import com.sulimann.iniciandocomjpa.entities.StatusPedido;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class MapeandoOneToOneTest extends EntityManagerTest {

    @Test
    public void criarPedidoEAssociarPagamentoCartao() {
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

        PagamentoCartao pagamentoCartao = new PagamentoCartao(pedido, StatusPagamento.PROCESSANDO, "123456");

        pedido.setPagamentoCartao(pagamentoCartao);

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(pedido);
        super.entityManager.persist(pagamentoCartao);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Pedido pedidoVerificacao = super.entityManager.find(Pedido.class, pedido.getId());
        System.out.println(pedidoVerificacao);
        Assertions.assertNotNull(pedidoVerificacao);

        Assertions.assertNotNull(pedidoVerificacao.getPagamentoCartao());
        System.out.println(pedidoVerificacao.getPagamentoCartao());
    }

    @Test
    public void criarPedidoEAssociarNotaFiscal(){
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

        Pedido pedidoVerificacao = super.entityManager.find(Pedido.class, pedido.getId());
        System.out.println(pedidoVerificacao);
        Assertions.assertNotNull(pedidoVerificacao);

        System.out.println(pedidoVerificacao.getNotaFiscal());
        Assertions.assertNotNull(pedidoVerificacao.getNotaFiscal());

    }

}
