package conta;

import java.util.logging.Logger;

import conta.models.Usuario;
import conta.models.Conta;
//import conta.models.ContaCorrente;
//import conta.models.ContaInvestimento;

public class App {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.criarConta("corrente", 300.0);
        Conta contaCorrente = usuario.getConta("corrente");
        contaCorrente.depositar(500.0);

        System.out.println("Saldo: " + contaCorrente.getSaldo());

    }
}
