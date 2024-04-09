package conta.models;

import conta.models.interaces.OperacoesConta;


public class ContaCorrente extends Conta {
  public ContaCorrente(Double saldoInicial) {
    super(saldoInicial);
  }

  @Override
  public void depositar(Double valor) {
    if (valor > 0) {
      super.depositar(valor);
    } else {
      throw new RuntimeException("Valor de depósito inválido.");
    }
  }

  @Override
  public void sacar(Double valor) {
    if (getSaldo() - valor >= -500.0) {
      super.sacar(valor);
    } else {
      throw new RuntimeException("A conta só pode ficar negativa em R$ 500.00.");
    }
  }

  @Override
  public Double getSaldo() {
    return super.getSaldo();
  }
}