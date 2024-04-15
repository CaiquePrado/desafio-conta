package conta;

import conta.models.Usuario;
import conta.models.Conta;

public class App {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.criarConta("investimento", 1000.0);
        Conta contaInvestimento = usuario.getConta("investimento");
        contaInvestimento.sacar(900.0);

        System.out.println("Saldo: " + contaInvestimento.getSaldo());

    }
}
