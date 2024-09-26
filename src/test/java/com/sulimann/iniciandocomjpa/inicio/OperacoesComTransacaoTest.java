package com.sulimann.iniciandocomjpa.inicio;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class OperacoesComTransacaoTest extends EntityManagerTest {


    @Test
    public void desanexarObjetoComDetach(){
        Produto produto = super.entityManager.find(Produto.class, 1);
        produto.setNome("TESTE MERGE!");
        produto.setDescricao("TESTE MERGE!");
        produto.setPreco(new BigDecimal(0).setScale(2, RoundingMode.UP));
        super.entityManager.detach(produto);
        super.entityManager.merge(produto);

        super.entityManager.getTransaction().begin();
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();
        Produto produtoAtualizado = super.entityManager.find(Produto.class, produto.getId());
        System.out.println("Produto atualizado: " + produtoAtualizado);
        Assertions.assertEquals("TESTE MERGE!", produtoAtualizado.getNome());
        Assertions.assertEquals("TESTE MERGE!", produtoAtualizado.getDescricao());
        Assertions.assertEquals(new BigDecimal(0).setScale(2, RoundingMode.UP), produtoAtualizado.getPreco());
    }

    @Test
    public void mostrarDiferencaMerge(){
        Produto produtoMerge = new Produto(
            "Câmera Canon",
            "A melhor definição para suas fotos",
            new BigDecimal("5000.0")
        );

        produtoMerge.setId(11L);

        super.entityManager.getTransaction().begin();
        produtoMerge = super.entityManager.merge(produtoMerge);
        produtoMerge.setNome("Câmera Canon 2");
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();
        Produto produtoMergePersistido = super.entityManager.find(Produto.class, 11L);
        Assertions.assertNotNull(produtoMergePersistido);
        Assertions.assertEquals("Câmera Canon 2", produtoMergePersistido.getNome());
        System.out.println("Produto merge: " + produtoMergePersistido);
    }

    @Test
    public void mostrarDiferencaPersist(){
        Produto produtoPersist = new Produto(
            "Câmera Canon",
            "A melhor definição para suas fotos",
            new BigDecimal("5000.0")
        );

        //produtoPersist.setId(11L);

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(produtoPersist);
        produtoPersist.setNome("Câmera Canon 2");
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();
        Produto produtoPersistido = super.entityManager.find(Produto.class, 11L);
        Assertions.assertNotNull(produtoPersistido);
        Assertions.assertEquals("Câmera Canon 2", produtoPersistido.getNome());
    }

    @Test
    public void inserirObjetoComMerge(){
        Produto produto = new Produto(
            "Câmera Canon",
            "A melhor definição para suas fotos",
            new BigDecimal("5000.0")
        );

        produto.setId(11L);

        super.entityManager.getTransaction().begin();
        super.entityManager.merge(produto);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();
        Produto produtoAtualizado = super.entityManager.find(Produto.class, 11L);
        Assertions.assertNotNull(produtoAtualizado);
    }

    @Test
    public void atualizarObjetoGerenciado(){
        Produto produto = super.entityManager.find(Produto.class, 1);
        produto.setNome("TESTE MERGE!");
        produto.setDescricao("TESTE MERGE!");
        produto.setPreco(new BigDecimal(0).setScale(2, RoundingMode.UP));

        super.entityManager.getTransaction().begin();
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();
        Produto produtoAtualizado = super.entityManager.find(Produto.class, produto.getId());
        System.out.println("Produto atualizado: " + produtoAtualizado);
        Assertions.assertEquals("TESTE MERGE!", produtoAtualizado.getNome());
        Assertions.assertEquals("TESTE MERGE!", produtoAtualizado.getDescricao());
        Assertions.assertEquals(new BigDecimal(0).setScale(2, RoundingMode.UP), produtoAtualizado.getPreco());
    }

    @Test
    public void atualizarObjeto(){
        Produto produto = new Produto(
            "TESTE MERGE!",
            "TESTE MERGE!",
            new BigDecimal(0).setScale(2, RoundingMode.UP)
        );

        produto.setId(1L);

        super.entityManager.getTransaction().begin();
        super.entityManager.merge(produto);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();
        Produto produtoAtualizado = super.entityManager.find(Produto.class, produto.getId());
        System.out.println("Produto atualizado: " + produtoAtualizado);
        Assertions.assertEquals("TESTE MERGE!", produtoAtualizado.getNome());
        Assertions.assertEquals("TESTE MERGE!", produtoAtualizado.getDescricao());
        Assertions.assertEquals(new BigDecimal(0).setScale(2, RoundingMode.UP), produtoAtualizado.getPreco());
    }

    @Test
    public void removerObjeto() {
        Produto produto = super.entityManager.find(Produto.class, 1);

        super.entityManager.getTransaction().begin();
        super.entityManager.remove(produto);
        super.entityManager.getTransaction().commit();

        // super.entityManager.clear(); Não é necessário pois o método remove já remove o objeto do contexto de persistência

        Produto produtoRemovido = super.entityManager.find(Produto.class, 1);
        Assertions.assertNull(produtoRemovido);
    }

    @Test
    public void inserirPrimeiroObjeto() {
        Produto produto = new Produto(
            "Câmera Canon",
            "A melhor definição para suas fotos",
            new BigDecimal("5000.0")
        );

        // produto.setId(11L); -> Como a estratégia de geração de chave primária é IDENTITY, não é necessário setar o ID

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(produto);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();
        Produto produtoNovo = super.entityManager.find(Produto.class, produto.getId());
        Assertions.assertNotNull(produtoNovo);
    }

    @Test
    public void abrirEFecharTransacao() {
        super.entityManager.getTransaction().begin();

        // Aqui fazemos as operações de:
        // 1) persist
        // 2) merge
        // 3) remove

        super.entityManager.getTransaction().commit();
    }

}
