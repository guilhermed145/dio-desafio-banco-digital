public class App {
    public static void main(String[] args) {
        
        Banco bancoExemplo = new Banco("Banco Exemplo");

        Cliente joao = new Cliente("Joao", "12345678910");
        Cliente maria = new Cliente("Maria", "98765432190");
        Cliente pedro = new Cliente("Pedro", "48593049450");

        ContaCorrente contaJoao = bancoExemplo.criarContaCorrente(joao, "0001");
        ContaCorrente contaMaria = bancoExemplo.criarContaCorrente(maria, "0002");
        ContaCorrente contaPedroCorrente = bancoExemplo.criarContaCorrente(pedro, "0001");
        ContaPoupanca contaPedroPoupanca = bancoExemplo.criarContaPoupanca(pedro, "0001");

        // Imprime todas as contas adicionadas ao banco.
        bancoExemplo.imprimirContas();

        // Realização de depósitos nas contas bancárias.
        contaJoao.depositar(200.50);
        contaMaria.depositar(100.90);
        contaPedroPoupanca.depositar(300.00);

        // Realização de saques nas contas bancárias.
        contaJoao.sacar(30.40);
        contaPedroPoupanca.sacar(10.00);

        // Transferência de uma conta para outra.
        contaJoao.transferir(50.0, contaPedroCorrente);

        // Tentativa de sacar um valor maior do que há no saldo da conta.
        contaMaria.sacar(200.00);

        // Tentativa de gastar mais crédito do que há no limite.
        contaJoao.gastarCredito(2000.00);

        // Ajuste no limite de crédito.
        contaJoao.setLimiteCredito(1500.00);

        // Compra realizada no credito.
        contaJoao.gastarCredito(1200.0);

        // Imprimir os extratos de todas as contas bancárias registradas.
        for (Conta contaBancaria : bancoExemplo.getContas()) {
            contaBancaria.imprimirExtrato();
        }

    }
}
