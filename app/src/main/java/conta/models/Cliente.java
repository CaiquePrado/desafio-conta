package conta.models;

import java.util.List;

import conta.models.interaces.OperacoesConta;

public class Cliente {
  
  private List<Conta> listaDeContas;

    public double valor(OperacoesConta  operacoesconta){
      double valor = operacoesconta.saldo();
        return valor;
    }
}
