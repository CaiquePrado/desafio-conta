package conta;

import java.util.logging.Logger;

import conta.models.Cliente;
import conta.models.Conta;
import conta.models.ContaCorrente;
import conta.models.ContaInvestimento;

public class App {

    private static final Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        Conta contaCorrente = new ContaCorrente(50.0D);
        Conta contaInvestimento = new ContaInvestimento(1000.0D);

        cliente.valor(contaCorrente);
        cliente.valor(contaInvestimento);
    }
}
