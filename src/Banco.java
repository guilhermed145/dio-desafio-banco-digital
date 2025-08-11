import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private final List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public ContaCorrente criarContaCorrente(Cliente cliente, String agencia) {
        ContaCorrente novaConta = new ContaCorrente(cliente, agencia);
        contas.add(novaConta);
        return novaConta;
    }

    public ContaPoupanca criarContaPoupanca(Cliente cliente, String agencia) {
        ContaPoupanca novaConta = new ContaPoupanca(cliente, agencia);
        contas.add(novaConta);
        return novaConta;
    }

    public void imprimirContas() {
        System.out.println("\n==========Contas Registradas No Banco==========");
        for (Conta conta : contas) {
            if (conta instanceof ContaPoupanca) {
                System.out.println("\n - Conta Poupanca - ");
            } else {
                System.out.println("\n - Conta Corrente - ");
            }
            System.out.println("Cliente: " + conta.getTitular().getNome());
            System.out.println("Numero da Conta: " + conta.getNumero());
            System.out.println("Agencia: " + conta.getAgencia());
            System.out.println("Saldo: " + conta.getSaldoFormatado() + "\n");
        }
    }

    public static String formatarValor(double valor) {
        return String.format("%.2f", valor);
    }

}
