package semana1.segunda;

import java.util.Scanner;

public class ExerEstadio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int valorClasseA = 50;
        int valorClasseB = 30;
        int valorClasseC = 20;

        System.out.println("Quantos bilhetes da classe A foi vendido?");
        int ingressosClasseA = scanner.nextInt();
        System.out.println("Quantos bilhetes da classe B foi vendido?");
        int ingressosClasseB = scanner.nextInt();
        System.out.println("Quantos bilhetes da classe C foi vendido?");
        int ingressosClasseC = scanner.nextInt();

        System.out.println("---------------------------------RESULTADO--------------------------------");
        System.out.printf("Foram vendidos %d Ingressos da Classe A, totalizando R$%d Reais arrecadados.\n",
                ingressosClasseA, valorClasseA * ingressosClasseA);
        System.out.printf("Foram vendidos %d Ingressos da Classe B, totalizando R$%d Reais arrecadados.\n",
                ingressosClasseB, valorClasseB * ingressosClasseB);
        System.out.printf("Foram vendidos %d Ingressos da Classe C, totalizando R$%d Reais arrecadados.\n",
                ingressosClasseC, valorClasseC * ingressosClasseC);

        scanner.close();

    }
}
