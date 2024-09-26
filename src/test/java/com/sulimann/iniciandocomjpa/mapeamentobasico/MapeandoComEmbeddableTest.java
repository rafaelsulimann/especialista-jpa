package com.sulimann.iniciandocomjpa.mapeamentobasico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Cliente;
import com.sulimann.iniciandocomjpa.entities.EnderecoEntregaPedido;
import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.entities.StatusPedido;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class MapeandoComEmbeddableTest extends EntityManagerTest {

    @Test
    public void inserirPedidoComEmbeddable(){
        Cliente cliente = super.entityManager.find(Cliente.class, 1L);
        Assertions.assertNotNull(cliente);

        Pedido pedido = new Pedido(
            LocalDateTime.now(),
            StatusPedido.AGUARDANDO,
            new BigDecimal(1000),
            new EnderecoEntregaPedido(
                "38400-000",
                "Rua das Laranjeiras",
                "123",
                "Bairro Qualquer",
                "Uberlândia",
                "MG"
            ),
            cliente
        );

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(pedido);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Pedido pedidoVerificacao = super.entityManager.find(Pedido.class, pedido.getId());
        System.out.println(pedidoVerificacao);
        Assertions.assertNotNull(pedidoVerificacao);
        Assertions.assertNotNull(pedidoVerificacao.getEnderecoEntrega());
        Assertions.assertEquals("38400-000", pedidoVerificacao.getEnderecoEntrega().getCep());
    }
}
