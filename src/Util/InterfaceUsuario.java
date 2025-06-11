package Util;

import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    // Métodos
    public double pedirValorImovel() {
        while (true) {
            System.out.println("\nDigite o valor do imóvel desejado: ");
            double valorImovel = scanner.nextDouble();
            if (valorImovel >= 1 && valorImovel <= 9000000) {
                return valorImovel;
            } else {
                System.out.println("Erro: Imóvel com valor inválido!");
            }
        }
    }

    public int pedirPrazofinanciamento() {
        while (true) {
            System.out.println("\nDigite um prazo para o financiamento até 35 anos: ");
            int valorPrazo = scanner.nextInt();
            if (valorPrazo >= 1 && valorPrazo <= 35) {
                return valorPrazo;
            } else {
                System.out.println("Erro: Prazo com valor inválido!");
            }
        }
    }

    public double pedirTaxadeJuros() {
        while (true) {
            System.out.println("\nDigite o valor da taxa de juros anual: ");
            double valorTaxadeJuros = scanner.nextDouble();
            if (valorTaxadeJuros >= 1 && valorTaxadeJuros <= 30 ) {
                return valorTaxadeJuros;
            } else {
                System.out.println("Erro: Taxa de juros com valor inválido!");
            }
        }
    }
}