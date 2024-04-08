package conta.models.interaces;

public interface OperacoesConta {

  void depositar(Double valor);
  void sacar(Double valor);
  Double getSaldo();
  
}