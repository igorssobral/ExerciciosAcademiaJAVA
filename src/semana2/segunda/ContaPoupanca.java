package semana2.segunda;

import semana1.quarta.atividade2.erros.EstouroSaqueException;

public class ContaPoupanca extends ContaBancaria {

    private double taxaDeJuros;

    public ContaPoupanca(String numeroConta, double saldo, double taxaDeJuros) {
        super(numeroConta, saldo);
        this.taxaDeJuros = taxaDeJuros;
    }

    @Override
    void sacar(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " efetuado com Sucesso!");
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

    public void aplicarJuros() {
        double saldoAtual = getSaldo();
        double juros = saldoAtual * taxaDeJuros;
        setSaldo(saldoAtual + juros);
        System.out.println("Taxa de juros: +R$" + juros+" Aplicada!");
    }

    @Override
    void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Taxa de juros: " + taxaDeJuros);
    }
}
