package conta;

import conta.models.ContaInvestimento;
import conta.models.ContaPoupanca;
import conta.models.Usuario;
import conta.models.Conta;

public class App {

    public static void main(String[] args) {

          // TESTE CONTA CORRENTE
//         Usuario usuario = new Usuario();
//         usuario.criarConta("corrente", 0.0);
//         Conta contaCorrente = usuario.getConta("corrente");
//         System.out.println("Saldo inicial: " + contaCorrente.getSaldo());
//         contaCorrente.depositar(500.0);
//         System.out.println("Saldo após depósito de R$ 500.00: " +
//         contaCorrente.getSaldo());
//         contaCorrente.sacar(200.0);
//         System.out.println("Saldo após saque de R$ 200.00: " +
//         contaCorrente.getSaldo());
//         try {
//         contaCorrente.sacar(2000.0);
//         } catch (RuntimeException ex) {
//         System.out.println(ex.getMessage());
//         }
//         usuario.fecharConta("corrente");
//         System.out.println("Conta corrente fechada com sucesso.");

          // TESTE CONTA POUPANÇA
//          ContaPoupanca contaPoupanca = new ContaPoupanca(50.0);
//          System.out.println("Saldo após a abertura da conta: " +
//          contaPoupanca.getSaldo());
//          try {
//          contaPoupanca.sacar(30.0);
//          System.out.println("Saldo após o saque: " + contaPoupanca.getSaldo());
//          } catch (RuntimeException e) {
//          System.out.println("Erro ao tentar sacar: " + e.getMessage());
//          }
//          contaPoupanca.setDataDeAbertura(contaPoupanca.getDataDeAbertura().minusDays(1));
//          System.out.println("Saldo após um dia do depósito inicial: " +
//          contaPoupanca.getSaldo());
//    }

          // // TESTE CONTA INVESTIMENTO
          ContaInvestimento contaInvestimento = new ContaInvestimento(1000.0);
          System.out.println("Saldo após a abertura da conta: " +
                  contaInvestimento.getSaldo());
          try {
                contaInvestimento.sacar(500.0);
          } catch (RuntimeException e) {
                System.out.println("Erro ao tentar sacar: " + e.getMessage());
          }
          contaInvestimento.setDataDeAbertura(contaInvestimento.getDataDeAbertura().minusDays(1));
          try {
                contaInvestimento.sacar(500.0);
                System.out.println("Saldo após o saque: " + contaInvestimento.getSaldo());
          } catch (RuntimeException e) {
                System.out.println("Erro ao tentar sacar: " + e.getMessage());
          }
          contaInvestimento.setDataDeAbertura(contaInvestimento.getDataDeAbertura().minusDays(1));
          System.out.println("Saldo após dois dias do depósito inicial: " +
                  contaInvestimento.getSaldo());
    }
}
