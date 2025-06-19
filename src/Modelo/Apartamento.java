package Modelo;

public class Apartamento extends Financiamento{
    public Apartamento ( double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }
    // Calcular taxa mensal
    // Calcular o financiamento em meses


    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100.00;
        double finaciamentoMeses = getPrazoFinanciamento() * 12;

        return (getValorImovel() * taxaMensal * Math.pow(1 + taxaMensal, finaciamentoMeses)) / (Math.pow(1 + taxaMensal, finaciamentoMeses) -1);
    }
}
