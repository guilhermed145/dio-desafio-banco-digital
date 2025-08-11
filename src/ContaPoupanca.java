public class ContaPoupanca extends Conta {

    public static double taxaSelic = 15.0;

    public ContaPoupanca(Cliente cliente, String agencia) {
        super(cliente, agencia);
    }

    public double calcularRendimentoDoMes() {
        if (taxaSelic > 8.5) {
            return 0.05 * getSaldo();
        } else {
            return (0.7 * taxaSelic / 100) * getSaldo();
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n==========Extrato da Conta Poupanca==========");
        System.out.println("Nome do Titular: " + getTitular().getNome());
        System.out.println("CPF do Titular: " + getTitular().getCpf());
        System.out.println("Numero da conta: " + getNumero());
        System.out.println("Agencia: " + getAgencia());
        System.out.println("Saldo: " + getSaldoFormatado());
        System.out.println("Saldo apos rendimento do mes: " + Banco.formatarValor(getSaldo() + calcularRendimentoDoMes()));
    }

}
