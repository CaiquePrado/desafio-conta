package conta.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import conta.models.interaces.OperacoesConta;

public class Usuario {
    private Map<String,Conta> listaDeContas = new HashMap<>();

    public void criarConta(String tipoDaConta, Double saldoInicial){
      switch (tipoDaConta){

        case "corrente":
          listaDeContas.put(tipoDaConta, new ContaCorrente(saldoInicial));
          break;
        case "investimento":
          listaDeContas.put(tipoDaConta, new ContaInvestimento(saldoInicial));
          break;
        case "poupanca":
          listaDeContas.put(tipoDaConta, new ContaPoupanca(saldoInicial));
          break;
        default:
          throw new RuntimeException("Tipo de conta inválido.");
      }
    }

    public Conta getConta(String tipoDaConta){
      return listaDeContas.get(tipoDaConta);
    }

    public Double getSaldoTotal(){
      double total = 0.0;
      for (Conta conta : listaDeContas.values()) {
        total += conta.getSaldo();
      }
      return total;
    }

}
