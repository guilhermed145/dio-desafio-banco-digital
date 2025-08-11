public class ContaCorrente extends Conta {

    private double valorCredito;
    private double limiteCredito;

    public ContaCorrente(Cliente cliente, String agencia) {
        super(cliente, agencia);
        valorCredito = 0;
        limiteCredito = 1000;
    }

    public String getValorCredito() {
        return Banco.formatarValor(valorCredito);
    }

    public String getLimiteCredito() {
        return Banco.formatarValor(limiteCredito);
    }

    public void gastarCredito(double valor) {
        if (valorCredito + valor > limiteCredito) {
            System.out.println("Nao ha credito suficiente para realizar esta compra.");
        } else {
            valorCredito += valor;
            System.out.println("O cliente " + getTitular().getNome() + " gastou R$" + Banco.formatarValor(valor) + " de credito.");
        }
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        System.out.println("O cliente " + getTitular().getNome() + " teve o credito ajustado para R$" + getLimiteCredito() + ".");
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n==========Extrato da Conta Corrente==========");
        System.out.println("Nome do Titular: " + getTitular().getNome());
        System.out.println("CPF do Titular: " + getTitular().getCpf());
        System.out.println("Numero da conta: " + getNumero());
        System.out.println("Agencia: " + getAgencia());
        System.out.println("Saldo: " + getSaldoFormatado());
        System.out.println("Valor gasto no credito: " + getValorCredito());
        System.out.println("Limite do credito: " + getLimiteCredito());
    }

}
