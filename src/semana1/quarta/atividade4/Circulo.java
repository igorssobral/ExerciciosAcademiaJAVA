package semana1.quarta.atividade4;

public class Circulo {
    private double raio;
    private double area;
    private double perimetro;

    public Circulo() {
    }

    public Circulo(double raio) {
        this.raio = raio;

    }

    public void calcularArea() {
        this.area = this.raio * this.raio * 3.14;
    }


    public void calcularPerimetro() {
        this.perimetro = 2 * 3.14 * this.raio;
    }

    public double getArea() {
        return area;
    }



    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getPerimetro() {
        return perimetro;
    }


}
