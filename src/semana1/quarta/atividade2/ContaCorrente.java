package semana1.quarta.atividade2;

import semana1.quarta.atividade2.erros.DepositoInvalidoException;
import semana1.quarta.atividade2.erros.EstouroSaqueException;

import java.util.Date;

public class ContaCorrente {

    private Cliente cliente;

    private int numero;

    private double saldo;

    private Date data;

    public ContaCorrente(Cliente cliente, int numero, double saldo, Date data) {
        this.cliente = cliente;
        this.numero = numero;
        this.saldo = saldo;
        this.data = data;
    }

    public void depositar(double valor) {
        if(valor < 0){
            throw new DepositoInvalidoException("Quantia Inválida!");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if(validarretirada(valor)){
            this.saldo -= valor;
        }else{
           throw new EstouroSaqueException("Saldo insuficiente! Saque cancelado!");
        }
    }

    public void transferir(double valor, ContaCorrente conta) {
            if(validarretirada(valor)){
                this.saldo -= valor;
                conta.saldo += valor;
            }else{
                System.out.println("Seu saldo:"+this.saldo +"\nVocê não tem o saldo de R$"+valor+" suficiente! Transferência cancelada!");
            }
    }

    public void exibirExtrato() {
        System.out.println("Cliente: " + this.cliente.getNome() + " - numero: " + this.numero + " - saldo: " + this.saldo + " - data: " + this.data);
    }

    private boolean validarretirada(double valor) {
        return valor <= this.saldo;
    }
}
