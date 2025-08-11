public abstract class Conta {
    
    private static int numeroDeContas = 0;

    private final Cliente titular; 
    private final String agencia;
    private final int numero;
    private double saldo;

    public Conta(Cliente titular, String agencia) {
        this.titular = titular;
        this.agencia = agencia;
        numero = ++numeroDeContas;
        saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getSaldoFormatado() {
        return Banco.formatarValor(saldo);
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("O cliente " + titular.getNome() + " depositou R$" + Banco.formatarValor(valor) + " em sua conta.");
    }

    public boolean sacar(double valor) {
        if (valor > saldo) {
            System.out.println("O valor a ser retirado da conta nao pode ser maior que o saldo!");
            return false;
        } else {
            saldo -= valor;
            System.out.println("O cliente " + titular.getNome() + " sacou R$" + Banco.formatarValor(valor) + " de sua conta.");
            return true;
        }
    }

    public void transferir(double valor, Conta conta) {
        if (sacar(valor)) {
            conta.depositar(valor);
            System.out.println(
                "O cliente " + conta.getTitular().getNome() + " recebeu R$" +
                Banco.formatarValor(valor) + " do cliente " + titular.getNome() + "."
            );
        } else {
            System.out.println("Nao foi possivel realizar a transferencia.");
        }
    }

    public abstract void imprimirExtrato();

}
