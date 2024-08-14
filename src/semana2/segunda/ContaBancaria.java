package semana2.segunda;

import semana1.quarta.atividade2.erros.DepositoInvalidoException;

public abstract class ContaBancaria {
    private String numeroConta;

    private double saldo;

    public ContaBancaria(String numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    void depositar(double valor) {
        if (valor <= 0) {
            throw new DepositoInvalidoException("Valor de depósito inválido!");
        }
        saldo += valor;
    }

    abstract void sacar(double valor);

    abstract void transferir(double valor, ContaBancaria destino);

    void exibirDetalhes() {
        System.out.println("Número da Conta: " + numeroConta + " saldo: " + saldo);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
