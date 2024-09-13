package com.sulimann.iniciandocomjpa.mapeamentobasico;

import com.sulimann.iniciandocomjpa.entities.Categoria;
import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class EstrategiaChavePrimariaTest extends EntityManagerTest {

    @Test
    public void estrategiaChavePrimariaMergeComIdentity(){
        Produto produto = new Produto();

        //produto.setId(1L); -> Não é necessário informar o ID, pois a estratégia de chave primária é IDENTITY
        produto.setNome("TESTE TOPZERA");
        produto.setDescricao("O TESTE DO MERGE");
        produto.setPreco(new BigDecimal("3000.0"));

        super.entityManager.getTransaction().begin();
        super.entityManager.merge(produto);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();
        Produto produtoAtualizado = super.entityManager.find(Produto.class, 11L);
        Assertions.assertNotNull(produtoAtualizado);
        System.out.println("Produto atualizado: " + produtoAtualizado);
    }
}
