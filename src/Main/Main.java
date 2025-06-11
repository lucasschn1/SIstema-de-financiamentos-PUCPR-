package Main;
import Util.InterfaceUsuario;
import Modelo.Financiamento;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> ListaFinanciamentos = new ArrayList<>();
        InterfaceUsuario iu = new InterfaceUsuario();

        // Financiamento 1
        double pedirValorImovel1 = iu.pedirValorImovel();
        int pedirPrazoFinanciamento1 = iu.pedirPrazofinanciamento();
        double pedirTaxaAnual1 = iu.pedirTaxadeJuros();

        Financiamento financiamento1 = new Financiamento(pedirValorImovel1, pedirPrazoFinanciamento1, pedirTaxaAnual1);
        financiamento1.calcularPagamentoMensal();
        financiamento1.calcularTotalDoPagamento();

        ListaFinanciamentos.add(financiamento1);

        // Financiamento 2
        double valorImovel2 = iu.pedirValorImovel();
        int prazofinanciamento2 = iu.pedirPrazofinanciamento();
        double taxaJuros2 = iu.pedirTaxadeJuros();

        Financiamento financiamento2 = new Financiamento(valorImovel2,prazofinanciamento2,taxaJuros2);
        financiamento2.calcularPagamentoMensal();
        financiamento2.calcularTotalDoPagamento();

        ListaFinanciamentos.add(financiamento2);

        // Financiamento 3
        double valorImovel3 = iu.pedirValorImovel();
        int prazoFinanciamento3 = iu.pedirPrazofinanciamento();
        double taxaJuros3 = iu.pedirTaxadeJuros();

        Financiamento financiamento3 = new Financiamento(valorImovel3,prazoFinanciamento3,taxaJuros3);
        financiamento3.calcularPagamentoMensal();
        financiamento3.calcularPagamentoMensal();

        ListaFinanciamentos.add(financiamento3);

        // Financiamento 4
        double valorImovel4 = iu.pedirValorImovel();
        int prazoFinanciamento4 = iu.pedirPrazofinanciamento();
        double taxaJuros4 = iu.pedirTaxadeJuros();

        Financiamento financiamento4 = new Financiamento(valorImovel4,prazoFinanciamento4,taxaJuros4);
        financiamento4.calcularPagamentoMensal();
        financiamento4.calcularTotalDoPagamento();

        ListaFinanciamentos.add(financiamento4);

        // Listar os financiamentos
        int contador = 1;
        double totalImovel = 0;
        for (Financiamento f: ListaFinanciamentos) {
            System.out.println("===FINANCIAMENTO " + contador + "====");
            f.mostrarFinanciamento();
            contador++;

            totalImovel += f.getValorImovel();
        }

        System.out.printf("O valor total dos imóveis é R$ %.2f%n", totalImovel);

        // Trasformar em método?
        double totalFinanciamento = financiamento4.calcularTotalDoPagamento() + financiamento3.calcularTotalDoPagamento() +
                financiamento2.calcularTotalDoPagamento() + financiamento1.calcularTotalDoPagamento();

        System.out.printf("O total dos financiamentos é R$ %.2f%n ", totalFinanciamento);

    }
}