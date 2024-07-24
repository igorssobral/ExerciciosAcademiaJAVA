package semana1.terca;

import java.util.Scanner;

public class ChessBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] board = {
                {"R", "N", "B", "Q", "K", "B", "N", "R"},
                {"P", "P", "P", "P", "P", "P", "P", "P"},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", " ", " ", " ", " "},
                {"p", "p", "p", "p", "p", "p", "p", "p"},
                {"r", "n", "b", "q", "k", "b", "n", "r"}
            };

            boolean jogador = true;  
            
            imprimirBoard(board);

            while (true) {
                System.out.println("Jogador " + (jogador ? "{1}" : "{2}") + ", é sua vez.");
                
                int origemLinha, origemColuna, destinoLinha, destinoColuna;

                while (true) {
                    System.out.println("Digite a posição de origem (linha e coluna): ");
                    origemLinha = scanner.nextInt();
                    origemColuna = scanner.nextInt();

                    if (isCoordenadaValida(origemLinha, origemColuna, board)) {
                        char pecaOrigem = board[origemLinha][origemColuna].charAt(0);

                        if ((jogador && Character.isUpperCase(pecaOrigem)) || 
                            (!jogador && Character.isLowerCase(pecaOrigem))) {
                            break;
                        } else {
                            System.out.println("Escolha uma peça válida do jogador " + (jogador ? "{1}" : "{2}") + ".");
                        }
                    } else {
                        imprimirBoard(board);
                        System.out.println("Coordenadas de origem inválidas.");
                    }
                }

                while (true) {
                    System.out.println("Digite a posição de destino (linha e coluna): ");
                    destinoLinha = scanner.nextInt();
                    destinoColuna = scanner.nextInt();

                    if (isCoordenadaValidaDestino(destinoLinha, destinoColuna)) {
                        break;
                    } else {
                        imprimirBoard(board);
                        System.out.println("Coordenadas de destino inválidas.");
                    }
                }

                board[destinoLinha][destinoColuna] = board[origemLinha][origemColuna];
                board[origemLinha][origemColuna] = " ";

                imprimirBoard(board);

                System.out.println("Deseja continuar? (s/n): ");
                char continuar = scanner.next().charAt(0);
                if (continuar == 'n') {
                    break;
                }

                jogador = !jogador;  // Alterna entre jogadores
            }

            scanner.close();
        }

        // Validação de coordenadas de origem
        public static boolean isCoordenadaValida(int linha, int coluna, String[][] board) {
            return linha >= 0 && linha < board.length && coluna >= 0 && coluna < board[0].length 
                && !board[linha][coluna].equals(" ");
        }

        // Validação de coordenadas de destino
        public static boolean isCoordenadaValidaDestino(int linha, int coluna) {
            return linha >= 0 && linha < 8 && coluna >= 0 && coluna < 8;
        }

    // Impressão do Tabuleiro
    public static void imprimirBoard(String[][] board) { 
    	System.out.println("0__1__2__3__4__5__6__7\n");
    	
        for (int i = 0; i < board.length; i++) {
        	
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
               
            }
            System.out.println("|"+i);
        }
        System.out.println("");
    }
}
