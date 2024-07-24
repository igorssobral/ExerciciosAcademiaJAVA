package semana1.quarta.atividade1;

import javax.swing.*;
import java.util.Scanner;

public class JogoDaVelhaJOptionPane {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[][] tabuleiro = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };

		int[][] combinacoesVencedoras = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
				{ 0, 4, 8 }, { 2, 4, 6 } };

		int jogadas = 0;
		String jogadorAtual = "X";

		do {
			// impressão do tabuleiro
			ImprimirTabuleiro(tabuleiro);
			realizarJogada(scanner, tabuleiro, jogadorAtual);
			jogadas++;

			if (verificarVencedor(tabuleiro, combinacoesVencedoras, jogadorAtual)) {
				JOptionPane.showMessageDialog(null,"\n\n----------- Jogador " + jogadorAtual + " ganhou! ------------");
				ImprimirTabuleiro(tabuleiro);
				break;
			}

			if (jogadas == 9) {
				JOptionPane.showMessageDialog(null,"----------- Empate! ------------");
				ImprimirTabuleiro(tabuleiro);
				break;
			}

			jogadorAtual = jogadorAtual.equals("X") ? "O" : "X";

		} while (true);
	}

	private static void ImprimirTabuleiro(String[][] tabuleiro) {
		System.out.print("\n\n 0   1   2\n\n");
		for (int posicao1 = 0; posicao1 < 3; posicao1++) {
			for (int posicao2 = 0; posicao2 < 3; posicao2++) {
				System.out.print(" " + tabuleiro[posicao1][posicao2]);
				if (posicao2 < 2) {
					System.out.print(" | ");
				}
				if (posicao2 == 2) {
					System.out.print("  " + posicao1);
				}
			}
			if (posicao1 < 2) {
				System.out.print("\n------------");
			}
			System.out.println("\n");
		}
	}

	private static void realizarJogada(Scanner scanner, String[][] tabuleiro, String jogador) {
		boolean escolhaValida = false;

		while (!escolhaValida) {
			int linha = Integer.parseInt(JOptionPane.showInputDialog("Jogador {" + jogador + "} Escolha uma linha [0,1 ou 2]:"));
			int coluna =  Integer.parseInt(JOptionPane.showInputDialog("Jogador {" + jogador + "} Escolha uma coluna [0,1 ou 2]:"));

			if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna].equals(" ")) {
				tabuleiro[linha][coluna] = jogador;
				escolhaValida = true;
			} else {
				JOptionPane.showMessageDialog(null,"Posição inválida ou já ocupada. Escolha outra.");
			}
		}
	}

	private static boolean verificarVencedor(String[][] tabuleiro, int[][] combinacoes, String jogador) {
		for (int i = 0; i < combinacoes.length; i++) {
			if (tabuleiro[combinacoes[i][0] / 3][combinacoes[i][0] % 3].equals(jogador)
					&& tabuleiro[combinacoes[i][1] / 3][combinacoes[i][1] % 3].equals(jogador)
					&& tabuleiro[combinacoes[i][2] / 3][combinacoes[i][2] % 3].equals(jogador)) {
				return true;
			}
		}
		return false;
	}
}
