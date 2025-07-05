package Modelo;


public class Casa extends Financiamento{
    private double areaConstruida;
    private double areaTerreno;

    public Casa ( double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida,
                  double areaTerreno) {
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

    /*
      - calcular o valor do juros na mensalidade
      - verificar se é maior que 80
      - aplicar exceção
     */

public void validarAumentoDeJuros(double valorAcrescimo) throws AumentoMaiorDoQueJurosException{
    double parcelaBase = getValorImovel() / (getPrazoFinanciamento() * 12);
    double taxaMensal = (getTaxaJurosAnual() /100) / 12;
    double jurosParcela = parcelaBase * taxaMensal;

    if (valorAcrescimo > (jurosParcela / 2)) {
        throw new AumentoMaiorDoQueJurosException("Aviso: Acréscimo de R$ 80,00 é maior que a metade dos juros mensais. " +
                "Valor ajustado para R$ 50,00");
    }
}


    @Override
    public double calcularPagamentoMensal() {
        double parcelaBase = getValorImovel() / (getPrazoFinanciamento() * 12);
        double taxaMensal = (getTaxaJurosAnual() /100) / 12;
        double jurosParcela = parcelaBase * taxaMensal;
        double valorAcrescimo = 80;

        try {
            validarAumentoDeJuros(valorAcrescimo);
        } catch (AumentoMaiorDoQueJurosException e) {
            valorAcrescimo = 50;
            System.out.println(e.getMessage());
        }

        return parcelaBase + jurosParcela + valorAcrescimo;
    }

    @Override
    public void mostrarFinanciamento(double mensal, double total) {
        System.out.println("\n----------Detalhes da Casa----------");
        System.out.println("Área do terreno: " + getAreaTerreno() + " m²");
        System.out.println("Área contruída: " + getAreaConstruida() +" m²\n");
        super.mostrarFinanciamento(mensal, total);
    }

    @Override
    public String toString() {
        String retorno = "";
        retorno += "Valor do imóvel: " + getValorImovel() + "\n";
        retorno += "Prazo do financiamento: " + getPrazoFinanciamento() + "\n";
        retorno += "Taxa de juro anual (%): " + getTaxaJurosAnual() + "\n";
        retorno += "Área construída em m²: " + getAreaConstruida()+ "\n";
        retorno += "Área do terreno em m²: " + getAreaTerreno() + "\n";
        return retorno;
    }
}
