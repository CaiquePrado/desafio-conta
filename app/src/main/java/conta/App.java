package conta;

import conta.models.Usuario;
import conta.models.Conta;

public class App {

    public static void main(String[] args) {

        // TESTE CONTA CORRENTE

         Usuario usuario = new Usuario();
         usuario.criarConta("corrente", 0.0);
         Conta contaCorrente = usuario.getConta("corrente");
         System.out.println("Saldo inicial: " + contaCorrente.getSaldo());
         contaCorrente.depositar(500.0);
         System.out.println("Saldo após depósito de R$ 500.00: " +
         contaCorrente.getSaldo());
         contaCorrente.sacar(200.0);
         System.out.println("Saldo após saque de R$ 200.00: " +
         contaCorrente.getSaldo());
         try {
         contaCorrente.sacar(2000.0);
         } catch (RuntimeException ex) {
         System.out.println(ex.getMessage());
         }
         usuario.fecharConta("corrente");
         System.out.println("Conta corrente fechada com sucesso.");

    }
}
