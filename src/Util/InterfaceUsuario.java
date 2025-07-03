package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    // Métodos
    public double pedirValorImovel() {
        while (true) {
            try {
                System.out.println("\nDigite o valor do imóvel desejado: ");
                double valorImovel = scanner.nextDouble();
                if (valorImovel >= 1 && valorImovel <= 9000000) {
                    return valorImovel;
                } else {
                    System.out.println("Erro: Imóvel com valor inválido! Maximo de R$ 9.000.000,00");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números válidos!");
                scanner.nextLine(); // Evita o loop infinito
            }
        }
    }

    public int pedirPrazofinanciamento() {
        while (true) {
            try {
                System.out.println("\nDigite um prazo para o financiamento até 35 anos: ");
                int valorPrazo = scanner.nextInt();
                if (valorPrazo >= 1 && valorPrazo <= 35) {
                    return valorPrazo;
                } else {
                    System.out.println("Erro: Prazo deve ser até 35 anos!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números válidos!");
                scanner.nextLine();
            }
        }
    }


    public double pedirTaxadeJuros() {
        while (true) {
            try {
                System.out.println("\nDigite o valor da taxa de juros anual: ");
                double valorTaxadeJuros = scanner.nextDouble();
                if (valorTaxadeJuros >= 1 && valorTaxadeJuros <= 30) {
                    return valorTaxadeJuros;
                } else {
                    System.out.println("Erro: Taxa de juros com valor inválido!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números válidos!");
                scanner.nextLine();
            }
        }
    }

    public double pedirAreaDoTerreno() {
        while (true) {
            try {
                System.out.println("\nDigite em m² a área do terreno: ");
                double areaTerreno = scanner.nextDouble();
                if (areaTerreno > 0) {
                    return areaTerreno;
                } else {
                    System.out.println("Erro: Área do terreno com valor invalido!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números válidos!");
                scanner.nextLine();
            }
        }
    }

    public double pedirAreaConstruida() {
        while (true) {
            try {
                System.out.println("\nDigite em m² a área construída: ");
                double areaConstrida = scanner.nextDouble();
                if (areaConstrida > 0) {
                    return areaConstrida;
                } else {
                    System.out.println("Erro: Área construída com valor invalido!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números válidos!");
                scanner.nextLine();
            }
        }
    }
}