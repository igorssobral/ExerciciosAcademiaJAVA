package semana1.quarta.atividade4;

import javax.swing.*;

public class CirculoPrincipal {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            criarCirculo(i);
        }
    }

    private static void criarCirculo(int numeroCirculo) {
        double raio = Double.parseDouble(JOptionPane.showInputDialog("Digite o Raio do Círculo " + numeroCirculo));
        Circulo circulo = new Circulo(raio);
        circulo.calcularArea();
        JOptionPane.showMessageDialog(null, "Área do Círculo " + numeroCirculo + ": " + circulo.getArea());

        circulo.calcularPerimetro();
        JOptionPane.showMessageDialog(null, "Perímetro do Círculo " + numeroCirculo + ": " + circulo.getPerimetro());

        raio = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo Raio do Círculo " + numeroCirculo));
        circulo.setRaio(raio);
        circulo.calcularArea();
        JOptionPane.showMessageDialog(null, "Área do Círculo " + numeroCirculo + ": " + circulo.getArea());

        circulo.calcularPerimetro();
        JOptionPane.showMessageDialog(null, "Perímetro do Círculo " + numeroCirculo + ": " + circulo.getPerimetro());
    }


}
