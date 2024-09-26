package com.sulimann.iniciandocomjpa.mapeandorelacionamento;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Categoria;
import com.sulimann.iniciandocomjpa.entities.Produto;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class MapeandoManyToManyTest extends EntityManagerTest {

    @Test
    public void inserirCategoriasEmProduto(){
        Produto produto = super.entityManager.find(Produto.class, 1L);
        Categoria categoria = super.entityManager.find(Categoria.class, 1L);
        Categoria categoria2 = super.entityManager.find(Categoria.class, 2L);
        Categoria categoria3 = super.entityManager.find(Categoria.class, 3L);

        super.entityManager.getTransaction().begin();
        produto.setCategorias(Arrays.asList(categoria, categoria2, categoria3));
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Produto produtoVerificacao = super.entityManager.find(Produto.class, produto.getId());
        Assertions.assertNotNull(produtoVerificacao);
        Assertions.assertFalse(produtoVerificacao.getCategorias().isEmpty());
        System.out.println("Produto Categorias:");
        produtoVerificacao.getCategorias().forEach(System.out::println);

        Categoria categoriaVerificacao = super.entityManager.find(Categoria.class, categoria.getId());
        Assertions.assertNotNull(categoriaVerificacao);
        Assertions.assertFalse(categoriaVerificacao.getProdutos().isEmpty());
        System.out.println("Categoria Produtos:");
        categoriaVerificacao.getProdutos().forEach(System.out::println);
    }

}
