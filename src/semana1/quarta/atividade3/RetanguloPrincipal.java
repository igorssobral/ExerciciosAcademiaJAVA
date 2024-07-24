package semana1.quarta.atividade3;

import javax.swing.*;

public class RetanguloPrincipal {

        public static void main(String[] args) {
            for (int i = 1; i <= 5; i++) {
                criarRetangulo(i);
            }
        }

        private static void criarRetangulo(int numeroRetangulo) {
            double lado1 = Double.parseDouble(JOptionPane.showInputDialog("Lado 1 do Retângulo " + numeroRetangulo));
            double lado2 = Double.parseDouble(JOptionPane.showInputDialog("Lado 2 do Retângulo " + numeroRetangulo));

            Retangulo retangulo = new Retangulo(lado1, lado2);
            retangulo.calcularArea();
            retangulo.calcularPerimetro();

            lado2 = Double.parseDouble(JOptionPane.showInputDialog("Novo lado 2 do Retângulo " + numeroRetangulo));

            retangulo.setLado2(lado2);
            retangulo.calcularArea();
            retangulo.calcularPerimetro();
        }
}
