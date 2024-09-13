package com.sulimann.iniciandocomjpa.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerTest {

  private static EntityManagerFactory entityManagerFactory;
  protected EntityManager entityManager;

  @BeforeAll
  public static void setUpBeforeAll() {
    entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
  }

  @AfterAll
  public static void tearDownAfterAll() {
    entityManagerFactory.close();
  }

  @BeforeEach
  public void setUp() {
    entityManager = entityManagerFactory.createEntityManager();
  }

  @AfterEach
  public void tearDown() {
    entityManager.close();
  }
}
