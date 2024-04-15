package conta.models;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
  private Map<String, Conta> listaDeContas = new HashMap<>();

  public void criarConta(String tipoDaConta, Double saldoInicial) {
    switch (tipoDaConta) {

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

  public void transferir(String daConta, String paraConta, Double saldoConta) {
    Conta contaOrigem = listaDeContas.get(daConta);
    Conta contaDestino = listaDeContas.get(paraConta);
    if (contaOrigem == null || contaDestino == null) {
      throw new RuntimeException("Alguma conta não existe.");
    } else if (contaOrigem.getSaldo() < saldoConta) {
      throw new RuntimeException("Saldo insuficiente na conta origem.");
    }
    contaOrigem.sacar(saldoConta);
    contaDestino.depositar(saldoConta);
    System.out.println("Transferência realizada com sucesso!");
  }

  public void fecharConta(String tipoDaConta) {
    Conta conta = listaDeContas.get(tipoDaConta);
    if (conta != null) {
      if (conta.getSaldo() > 0.0) {
        transferir(tipoDaConta, "corrente", conta.getSaldo());
      }
      listaDeContas.remove(tipoDaConta);
    } else {
      throw new RuntimeException("Conta não encontrada.");
    }
  }

  public Conta getConta(String tipoDaConta) {
    return listaDeContas.get(tipoDaConta);
  }

  public Double getSaldoTotal() {
    double total = 0.0;
    for (Conta conta : listaDeContas.values()) {
      total += conta.getSaldo();
    }
    return total;
  }

}
