package Modelo;

public class Terreno extends Financiamento{
    private String tipoDeZona;

    public Terreno ( double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, String tipoDeZona) {
        super(valorDesejadoImovel,prazoFinanciamentoAnos,taxaJurosAnual);
        this.tipoDeZona = tipoDeZona;
    }

    public String getTipoDeZona() {
        return this.tipoDeZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return ((getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12))) * 1.02;
    }

    @Override
    public void mostrarFinanciamento(double mensal, double total) {
        System.out.println("\n------Detalhes do Terreno------");
        System.out.println("Tipo de zona: " + getTipoDeZona() + "\n");
        super.mostrarFinanciamento(mensal,total);
    }

    @Override
    public String toString() {
        String retorno = "";
        retorno += "Valor do imóvel: " + getValorImovel() + "\n";
        retorno += "Prazo do financiamento: " + getPrazoFinanciamento() + "\n";
        retorno += "Taxa de juro anual (%): " + getTaxaJurosAnual() + "\n";
        retorno += "Tipo de zona do terreno: " + getTipoDeZona() + "\n";
        return retorno;
    }
}
