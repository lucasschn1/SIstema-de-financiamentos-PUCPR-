package Modelo;

public class Apartamento extends Financiamento{
    private int numeroAndar;
    private int numeroVagas;

    public Apartamento ( double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int numeroAndar, int numeroVagas) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.numeroAndar = numeroAndar;
        this.numeroVagas = numeroVagas;
    }

    public int getNumeroAndar() {
        return this.numeroAndar;
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100.00;
        double finaciamentoMeses = getPrazoFinanciamento() * 12;

        return (getValorImovel() * taxaMensal * Math.pow(1 + taxaMensal, finaciamentoMeses)) / (Math.pow(1 + taxaMensal, finaciamentoMeses) -1);
    }

    @Override
    public void mostrarFinanciamento() {
        System.out.println("\n------Apartamento------");
        System.out.println("Número do andar: " + getNumeroAndar());
        System.out.println("Quantidade de vagas na garagem: " + getNumeroVagas() + "\n");
        super.mostrarFinanciamento();
    }
}
