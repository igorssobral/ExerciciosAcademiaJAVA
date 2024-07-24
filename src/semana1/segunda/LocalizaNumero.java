package semana1.segunda;

import java.util.Scanner;

//Faça um programa para pesquisar o valor 8 no vetor dado:
//inteiro vetor[] = {1, 3, 5, 8, 9, 10}
public class LocalizaNumero {
    // Corrigir este algoritmo.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Digite um numero: ");
        int numero = scanner.nextInt();

        boolean achou = false;

        for (int i = 0; i < 10; i++) {
            if (vetor[i] == numero) {
                achou = true;
            }
            if (achou) {
                System.out.println("Achei");
                System.out.printf("Na Posição %d está localizado do numero %d.", i, vetor[i]);
            }
            achou = false;
        }
        scanner.close();

    }

}
