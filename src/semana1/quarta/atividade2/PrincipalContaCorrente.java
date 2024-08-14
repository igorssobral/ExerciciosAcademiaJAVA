package semana1.quarta.atividade2;

import semana1.quarta.atividade2.erros.DepositoInvalidoException;

import java.util.Date;

public class PrincipalContaCorrente {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Igor", "Sobral", "12345678909");
        ContaCorrente conta1 = new ContaCorrente(cliente1, 11,1000, new Date());

        Cliente cliente2 = new Cliente("Maria", "Lima", "98765432121");
        ContaCorrente conta2 = new ContaCorrente(cliente2, 22,1000, new Date());
        //Valores iniciais
        System.out.println("\n---VALORES INICIAIS---");
        conta1.exibirExtrato();
        conta2.exibirExtrato();

        //Transferindo para a conta 2
        System.out.println("\n---TRANSFERÊNCIA ENTRE CONTAS---");
        conta1.transferir(500,conta2);
        conta1.exibirExtrato();
        conta2.exibirExtrato();

        //Transferindo para a conta 2
        System.out.println("\n---TRANSFERÊNCIA ENTRE CONTAS COM SALDO INSUFICIENTE---");
        conta1.transferir(5000,conta2);
        conta1.exibirExtrato();
        conta2.exibirExtrato();

        //Depositando nas contas
        System.out.println("\n---DEPOSITO NAS CONTAS---");

        try {
            conta1.depositar(-1);
        }catch (DepositoInvalidoException e){
            System.out.println("Erro: "+ e.getMessage());
        }

        conta1.exibirExtrato();
        conta2.depositar(750);
        conta2.exibirExtrato();


        //Sacando das contas com saldo insifuciente
        System.out.println("\n-----SAQUE COM SALDO ------");
        conta1.sacar(300);
        conta1.exibirExtrato();
        conta2.sacar(350);
        conta2.exibirExtrato();

        //Sacando das contas com saldo insifuciente
        System.out.println("\n-----SAQUE COM SALDO INSUFICIENTE------");
        conta1.sacar(3000);
        conta1.exibirExtrato();
        conta2.sacar(3500);
        conta2.exibirExtrato();


    }
}
