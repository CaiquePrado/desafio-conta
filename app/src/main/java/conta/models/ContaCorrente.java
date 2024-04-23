package conta.models;

public class ContaCorrente extends Conta {
  public ContaCorrente(Double saldoInicial) {
    super(saldoInicial);
  }


  @Override
  public void sacar(Double valor) {
    if (getSaldo() - valor >= -500.0) {
      super.sacar(valor);
    } else {
      throw new RuntimeException("A conta só pode ficar negativa em R$ 500.00.");
    }
  }
}