package semana1.quarta.atividade3;

import javax.swing.*;

public class Retangulo {
    private double lado1;
    private double lado2;
    private double area;
    private double perimetro;

    public Retangulo() {
    }

    public Retangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public void calcularArea() {
        this.area = this.lado1 * this.lado2;
        JOptionPane.showMessageDialog(null,"\nÁrea do Retangulo: "+ this.area);
    }


    public void calcularPerimetro() {
        this.perimetro = 2 * (this.lado1 +this.lado2);
        JOptionPane.showMessageDialog(null,"Perimetro do Retangulo: "+ this.perimetro);
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }
}
