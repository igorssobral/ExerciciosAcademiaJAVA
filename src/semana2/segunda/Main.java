package semana2.segunda;

public class Main {
    public static void main(String[] args) {

        ContaCorrente contaCorrente = new ContaCorrente("1234", 1000.0, 10.0);
        ContaPoupanca contaPoupanca = new ContaPoupanca("5678", 500.0, 0.05);

        System.out.println("Detalhes da Conta Corrente:");
        contaCorrente.exibirDetalhes();
        System.out.println("\nDetalhes da Conta Poupanca:");
        contaPoupanca.exibirDetalhes();

        System.out.println("------------DEPÓSITO-------------");
        contaCorrente.depositar(200.0);
        contaPoupanca.depositar(100.0);
        contaCorrente.exibirDetalhes();
        contaPoupanca.exibirDetalhes();

        System.out.println("------------TARNSFERÊNCIA-------------");
        contaCorrente.transferir(150.0, contaPoupanca);
        contaPoupanca.aplicarJuros();
        contaPoupanca.exibirDetalhes();

        System.out.println("------------SAQUE-------------");
        contaCorrente.sacar(50.0);
        contaCorrente.exibirDetalhes();

        System.out.println("\nDetalhes da Conta Corrente após operações:");
        contaCorrente.exibirDetalhes();
        System.out.println("\nDetalhes da Conta Poupanca após operações:");
        contaPoupanca.exibirDetalhes();
    }
}
