package com.sulimann.iniciandocomjpa.mapeandorelacionamento;

import com.sulimann.iniciandocomjpa.entities.*;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeandoAutorelacionamentoTest extends EntityManagerTest {

    @Test
    public void inserirCategoriaComCategoriaPaiEObterCategoriaPaiECategoriasFilhas(){
        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletrônicos");

        Categoria categoria = new Categoria();
        categoria.setNome("Celulares");
        categoria.setCategoriaPai(categoriaPai);

        Categoria categoria2 = new Categoria();
        categoria2.setNome("CURSO EAD");
        categoria2.setCategoriaPai(categoriaPai);

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(categoriaPai);
        super.entityManager.persist(categoria);
        super.entityManager.persist(categoria2);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Categoria categoriaVerificacao = super.entityManager.find(Categoria.class, categoria.getId());
        Assertions.assertNotNull(categoriaVerificacao);
        Assertions.assertNotNull(categoriaVerificacao.getCategoriaPai());
        System.out.println("-----CATEGORIA FILHA------");
        System.out.println("1 - CATEGORIA FILHA -> " + categoriaVerificacao);
        System.out.println("2 - CATEGORIA PAI ASSOCIADO A FILHA -> " + categoriaVerificacao.getCategoriaPai());

        Categoria categoriaVerificacao2 = super.entityManager.find(Categoria.class, categoria2.getId());
        Assertions.assertNotNull(categoriaVerificacao2);
        Assertions.assertNotNull(categoriaVerificacao2.getCategoriaPai());
        System.out.println("-----CATEGORIA FILHA 2------");
        System.out.println("1 - CATEGORIA FILHA 2 -> " + categoriaVerificacao2);
        System.out.println("2 - CATEGORIA PAI ASSOCIADO A FILHA -> " + categoriaVerificacao2.getCategoriaPai());

        Categoria categoriaPaiVerificacao = super.entityManager.find(Categoria.class, categoriaVerificacao.getCategoriaPai().getId());
        Assertions.assertNotNull(categoriaPaiVerificacao);
        Assertions.assertFalse(categoriaPaiVerificacao.getCategoriasFilhas().isEmpty());
        System.out.println("-----CATEGORIA PAI------");
        System.out.println("1 - CATEGORIA PAI -> " + categoriaPaiVerificacao);
        System.out.println("2 - CATEGORIAS FILHAS ASSOCIADAS AO PAI:");
        categoriaPaiVerificacao.getCategoriasFilhas().forEach(System.out::println);

    }
}
