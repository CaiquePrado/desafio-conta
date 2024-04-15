package conta.models;

import conta.models.interaces.OperacoesConta;

public abstract class Conta implements OperacoesConta {
  private Double saldo;

  protected Conta(Double saldo) {
    this.saldo = saldo;
  }

  @Override
  public void depositar(Double valor) {
    if (valor > 0) {
      this.saldo += valor;
    } else {
      throw new RuntimeException("Valor de depósito inválido.");
    }
  }

  @Override
  public void sacar(Double valor) {
    if (this.saldo >= valor) {
      this.saldo -= valor;
    } else {
      throw new RuntimeException("Saldo insuficiente para saque.");
    }
  }

  @Override
  public Double getSaldo() {
    return this.saldo;
  }
}
