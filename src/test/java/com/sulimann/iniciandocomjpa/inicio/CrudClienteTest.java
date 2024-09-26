package com.sulimann.iniciandocomjpa.inicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Cliente;
import com.sulimann.iniciandocomjpa.entities.SexoCliente;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class CrudClienteTest extends EntityManagerTest {

    @Test
    public void inserirCliente(){
        Cliente cliente = new Cliente("Rafael", SexoCliente.MASCULINO);

        super.entityManager.getTransaction().begin();
        super.entityManager.persist(cliente);
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Cliente clienteCadastrado = super.entityManager.find(Cliente.class, cliente.getId());
        System.out.println(clienteCadastrado);
        Assertions.assertNotNull(clienteCadastrado);
        Assertions.assertEquals("Rafael", clienteCadastrado.getNome());
        Assertions.assertEquals(SexoCliente.MASCULINO, clienteCadastrado.getSexo());
    }

    @Test
    public void buscarCliente(){
        Cliente cliente = super.entityManager.find(Cliente.class, 1L);
        System.out.println(cliente);
        Assertions.assertNotNull(cliente);
        Assertions.assertEquals("Maria", cliente.getNome());
    }

    @Test
    public void atualizarCliente(){
        Cliente cliente = super.entityManager.find(Cliente.class, 1L);
        cliente.setNome("Luana");

        super.entityManager.getTransaction().begin();
        super.entityManager.getTransaction().commit();

        super.entityManager.clear();

        Cliente clienteAtualizado = super.entityManager.find(Cliente.class, cliente.getId());
        Assertions.assertEquals("Luana", clienteAtualizado.getNome());
    }

    @Test
    public void deletarCliente(){
        Cliente cliente = super.entityManager.find(Cliente.class, 1L);

        super.entityManager.getTransaction().begin();
        super.entityManager.remove(cliente);
        super.entityManager.getTransaction().commit();

        Cliente clienteDeletado = super.entityManager.find(Cliente.class, 1L);
        Assertions.assertNull(clienteDeletado);
    }
}
