package Modelo;

import Util.InterfaceUsuario;
import java.io.Serializable;

public abstract class Financiamento implements Serializable{
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

    // Método abstrato
    public abstract double calcularPagamentoMensal();

    public double calcularTotalDoPagamento(double mensal) {
        return mensal* this.prazoFinanciamento * 12;
    }

    public void mostrarFinanciamento(double mensal, double total){

        System.out.println("\n-----------------Resumo do Financiamento----------------");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", getValorImovel());
        System.out.println("Prazo do Financimento: " + getPrazoFinanciamento() + " anos");
        System.out.println("Taxa de juros anual: " + getTaxaJurosAnual());

        System.out.println("-------------------Resumo dos pagamentos-------------------");
        System.out.printf("Pagamento mensal: R$ %.2f%n",mensal);
        System.out.printf("Total do pagamento: R$ %.2f%n",total);
        System.out.println();
    }

    public static Financiamento criarFinanciamento(int tipo, InterfaceUsuario iu) {
        double valor = iu.pedirValorImovel();
        int prazo = iu.pedirPrazofinanciamento();
        double taxa = iu.pedirTaxadeJuros();

        switch (tipo) {
            // Casa
            case 1: {
                double areaConstruida = iu.pedirAreaConstruida();
                double areaTerreno = iu.pedirAreaDoTerreno();
                return new Casa(valor,prazo,taxa,areaConstruida,areaTerreno);
            }
            // Apartamento
            case 2: {
                int andar = iu.pedirAndar();
                int vagas = iu.pedirQuantidadeVagas();
                return new Apartamento(valor, prazo, taxa, andar,vagas);
            }
            // Terreno
            case 3: {
                String tipoZona = iu.pedirTipoDeArea();
                return new Terreno(valor, prazo,taxa,tipoZona);
            }
            default: {
                System.out.println("Tipo inválido");
                return null;
            }
        }
    }

    @Override
    public abstract String toString();
}