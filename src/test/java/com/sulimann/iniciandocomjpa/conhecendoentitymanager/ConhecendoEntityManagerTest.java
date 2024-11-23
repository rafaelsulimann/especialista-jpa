package com.sulimann.iniciandocomjpa.conhecendoentitymanager;

import org.junit.jupiter.api.Test;

import com.sulimann.iniciandocomjpa.entities.Cliente;
import com.sulimann.iniciandocomjpa.entities.SexoCliente;
import com.sulimann.iniciandocomjpa.utils.EntityManagerTest;

public class ConhecendoEntityManagerTest extends EntityManagerTest{

  @Test
  public void cicloTransient(){
    Cliente cliente = new Cliente("Rafael", SexoCliente.MASCULINO);
  }

  @Test
  public void cicloManagedComPersist(){
    Cliente cliente = new Cliente("Rafael", SexoCliente.MASCULINO);
    super.entityManager.persist(cliente);
  }

  @Test
  public void cicloManagedComFind(){
    Cliente cliente = super.entityManager.find(Cliente.class, 1L);
  }

  @Test
  public void cicloManagedComPersistAposRemove(){
    Cliente cliente = super.entityManager.find(Cliente.class, 1L);
    super.entityManager.remove(cliente);
    super.entityManager.persist(cliente);
  }

  @Test
  public void cicloManagerComMerge(){
    Cliente cliente = new Cliente("Rafael", SexoCliente.MASCULINO);
    Cliente clienteGerenciadoMerge = super.entityManager.merge(cliente);
  }

  @Test
  public void cicloRemoved(){
    Cliente cliente = super.entityManager.find(Cliente.class, 1L);
    super.entityManager.remove(cliente);
  }

  @Test
  public void cicloDetachedComDetach(){
    Cliente cliente = super.entityManager.find(Cliente.class, 1L);
    super.entityManager.detach(cliente);
  }

  @Test
  public void cicloDetachedComClear(){
    Cliente cliente = super.entityManager.find(Cliente.class, 1L);
    super.entityManager.clear();
  }

}
