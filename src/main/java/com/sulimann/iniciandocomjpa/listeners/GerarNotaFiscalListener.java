package com.sulimann.iniciandocomjpa.listeners;

import com.sulimann.iniciandocomjpa.entities.Pedido;
import com.sulimann.iniciandocomjpa.services.NotaFiscalService;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class GerarNotaFiscalListener {

  private final NotaFiscalService notaFiscalService = new NotaFiscalService();

  @PrePersist
  @PreUpdate
  public void gerarNotaFiscal(Pedido pedido){
    this.notaFiscalService.gerar(pedido);
  }

}
