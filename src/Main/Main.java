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

        // Financiamento Casa
        double valorCasa = iu.pedirValorImovel();
        int prazoAnos = iu.pedirPrazofinanciamento();
        double taxaAnualCasa = iu.pedirTaxadeJuros();
        double areaTerreno = iu.pedirAreaDoTerreno();
        double areaConstruida = iu.pedirAreaConstruida();

        ListaFinanciamentos.add(new Casa(valorCasa, prazoAnos, taxaAnualCasa, areaConstruida, areaTerreno));

        ListaFinanciamentos.add(new Terreno(100000, 35, 10,"Residencial"));

        ListaFinanciamentos.add(new Apartamento(100000,35,10,12,2));



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