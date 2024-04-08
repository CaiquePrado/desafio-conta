package conta.models;

import conta.models.interaces.OperacoesConta;

public abstract class Conta implements OperacoesConta {
  
  private Double saldo;

  public Conta( Double saldo){
    this.saldo = saldo;
  }

  public void depositar(Double valor){
    if(this.saldo >= valor){
      this.saldo -= valor;
    }
  }

  public void sacar(Double valor){
    if(this.saldo >= valor){
      this.saldo -= valor;
    }
  }

  public Double getSaldo(){
    return saldo;
  }

  public void setSaldo(Double saldo) {
    this.saldo = saldo;
  }
}
