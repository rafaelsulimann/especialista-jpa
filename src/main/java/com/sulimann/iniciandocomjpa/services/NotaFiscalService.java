package com.sulimann.iniciandocomjpa.services;

import com.sulimann.iniciandocomjpa.entities.Pedido;

public class NotaFiscalService {

  public void gerar(Pedido pedido){
    System.out.println("Aqui nós vamos gerar a nota fiscal do " + pedido);
  }

}
