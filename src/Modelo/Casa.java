package Modelo;


public class Casa extends Financiamento{
    private double areaConstruida;
    private double areaTerreno;

    public Casa ( double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos,taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaConstruida() {
        return this.areaConstruida;
    }

    public double getAreaTerreno() {
        return this.areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        return ((getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12)))+ 80;
    }

    @Override
    public void mostrarFinanciamento() {
        System.out.println("\n------Casa------");
        System.out.println("Área do terreno: " + getAreaTerreno() + " m²");
        System.out.println("Área contruída: " + getAreaConstruida() +" m²\n");
        super.mostrarFinanciamento();
    }
}
