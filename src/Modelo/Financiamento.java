package Modelo;

public abstract class Financiamento {
    // Atributos
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Construtor
    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    // Métodos
    public abstract double calcularPagamentoMensal();

    public double calcularTotalDoPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void mostrarFinanciamento(){
        System.out.println("\n-----------------Resumo do Financiamento----------------");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.println("Prazo do Financimento: " + getPrazoFinanciamento() + " anos");
        System.out.println("Taxa de juros anual: " + getTaxaJurosAnual());
        System.out.println("-------------------Resumo dos pagamentos-------------------");
        System.out.printf("Pagamento mensal: R$ %.2f%n",calcularPagamentoMensal() );
        System.out.printf("Total do pagamento: R$ %.2f%n", calcularTotalDoPagamento());
        System.out.println();
    }
}