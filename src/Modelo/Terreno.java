package Modelo;

public class Terreno extends Financiamento{
    public Terreno ( double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorDesejadoImovel,prazoFinanciamentoAnos,taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.02;
    }
}
