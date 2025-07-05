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
    public void mostrarFinanciamento(double mensal, double total) {
        System.out.println("\n------Detalhes do Apartamento------");
        System.out.println("Número do andar: " + getNumeroAndar());
        System.out.println("Quantidade de vagas na garagem: " + getNumeroVagas() + "\n");
        super.mostrarFinanciamento(mensal, total);
    }

    @Override
    public String toString() {
        String retorno = "";
        retorno += "Valor do imóvel: " + getValorImovel() + "\n";
        retorno += "Prazo do financiamento: " + getPrazoFinanciamento() + "\n";
        retorno += "Taxa de juro anual (%): " + getTaxaJurosAnual() + "\n";
        retorno += "Quantidades de vagas na garagem: " + getNumeroVagas() + "\n";
        retorno += "Número do andar: " + getNumeroAndar() + "\n";
        return retorno;
    }
}
