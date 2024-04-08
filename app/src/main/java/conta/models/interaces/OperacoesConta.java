package conta.models.interaces;

public interface OperacoesConta {

  void deposito(Double valor);
  void saque(Double valor);
  Double saldo();
  
}