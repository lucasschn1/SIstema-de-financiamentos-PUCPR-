package Main;
import Modelo.Apartamento;
import Modelo.Casa;
import Modelo.Terreno;
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
        ListaFinanciamentos.add(financiamento1);

        // Financiamento Casa
        double valorCasa = iu.pedirValorImovel();
        int prazoAnos = iu.pedirPrazofinanciamento();
        double taxaAnualCasa = iu.pedirTaxadeJuros();

        Financiamento casa1 = new Casa(valorCasa, prazoAnos, taxaAnualCasa);
        ListaFinanciamentos.add(casa1);

        // Financiamento Apartamento
        Financiamento apartamento1 = new Apartamento(100000, 35, 10);
        ListaFinanciamentos.add(apartamento1);

        // Financiamento Terreno
        Financiamento terreno1 = new Terreno(100000, 35, 10);
        ListaFinanciamentos.add(terreno1);

        // Financiamento teste
        ListaFinanciamentos.add(new Apartamento(100000, 35, 10));


        // Listar os financiamentos
        int contador = 1;
        double totalImovel = 0;
        double totalFinanciamento = 0;
        for (Financiamento f: ListaFinanciamentos) {
            System.out.println("===FINANCIAMENTO " + contador + "====");
            f.mostrarFinanciamento();
            contador++;

            totalImovel += f.getValorImovel();
            totalFinanciamento += f.calcularTotalDoPagamento();
        }

        System.out.printf("O valor total dos imóveis é R$ %.2f%n", totalImovel);
        System.out.printf("O valor total dos financiamentos é R$ %.2f%n", totalFinanciamento);

    }
}