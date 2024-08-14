package semana2.segunda;

import semana1.quarta.atividade2.erros.EstouroSaqueException;

public class ContaCorrente extends ContaBancaria {

    private double taxaDeOperacao;

    public ContaCorrente(String numeroConta, double saldo, double taxaDeOperacao) {
        super(numeroConta, saldo);
        this.taxaDeOperacao = taxaDeOperacao;
    }

    @Override
    void sacar(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            aplicarTaxaOperacao(valor);
        } else {
            throw new EstouroSaqueException("Você não tem saldo suficiente!");
        }
    }

    @Override
    void transferir(double valor, ContaBancaria destino) {
        if (valor <= getSaldo()) {
            sacar(valor);
            destino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada para a conta " + destino.getNumeroConta());

        }
    }

    @Override
    void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("taxa de operacao: " + taxaDeOperacao);
    }

    void aplicarTaxaOperacao(double valor) {
        double taxa = (valor * taxaDeOperacao) / 100;
        setSaldo(getSaldo() - taxa);
        System.out.println("Taxa de operacao: -R$" + taxa + " Aplicada!");
    }
}
