package Util;

import Modelo.Financiamento;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

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

    public int pedirAndar() {
        while (true) {
            try {
                System.out.println("Informe o andar do apartamento: ");
                int andar = scanner.nextInt();
                if (andar > 0 && andar <= 30) {
                    return andar;
                } else {
                    System.out.println("Esse andar não está disponível!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números válidos!");
                scanner.nextLine();
            }
        }
    }

    public int pedirQuantidadeVagas() {
        while (true) {
            try {
                System.out.println("Informe a quantidade de vagas: ");
                int vagas = scanner.nextInt();
                if (vagas > 0 && vagas <= 3) {
                    return vagas;
                } else {
                    System.out.println("Essa vaga não está disponível!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números válidos!");
                scanner.nextLine();
            }
        }
    }

    public String pedirTipoDeArea() {
        while (true) {
            System.out.println("Informe o tipo de área residencial (Residêncial/Comercial)");
            String tipoArea = scanner.next();
            if (tipoArea.equalsIgnoreCase("residencial") || tipoArea.equalsIgnoreCase("comercial")) {
                return tipoArea;
            } else {
                System.out.println("Tipo de área não reconhecida!");
            }
        }
    }

    public Financiamento criarFinanciamento() {
        System.out.println("Escolha o tipo de financiamento: ");
        System.out.println("1 - Casa");
        System.out.println("2 - Apartamento");
        System.out.println("3 - Terreno");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo >= 1 && tipo <= 3) {
            System.out.println("Financiamento criado!");
            return Financiamento.criarFinanciamento(tipo, this);
        } else {
            System.out.println("Financiamento não reconhecido!");
            return null;
        }

    }

    public void iniciarSistema(ArrayList<Financiamento> lista, InterfaceUsuario iu, String arquivo) throws Exception {
        while (true) {
            System.out.println("\nDeseja adicionar um novo financiamento?");
            System.out.println("0 - Não (Sair e salvar)");
            System.out.println("1 - Sim");
            System.out.println("2 - Ver financiamentos salvos");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                break;
            } else if (opcao == 1) {
                Financiamento f = iu.criarFinanciamento();
                if (f != null) {
                    lista.add(f);
                    System.out.println("Financiamento adicionado com sucesso!");
                } else {
                    System.out.println("Erro ao criar financiamento.");
                }
            } else if (opcao == 2) {
                iu.lerListaDoArquivo(arquivo);
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }


    public void lerListaDoArquivo(String arquivo) throws Exception {
        File file = new File(arquivo);

        if (!file.exists()) {
            System.out.println("Arquivo não encontrado.");
            return;
        }

        if (file.length() == 0) {
            System.out.println("Arquivo está vazio. Nenhum financiamento salvo.");
            return;
        }

        FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis);

        ArrayList<Financiamento> lista = (ArrayList<Financiamento>) ois.readObject();
        ois.close();
        fis.close();

        System.out.println("Lista lida do arquivo: \n");

        int contador = 1;
        double totalImovel = 0;
        double totalFinanciamento = 0;


        for (Financiamento f : lista) {
            System.out.println("===FINANCIAMENTO " + contador + "====");

            double mensal = f.calcularPagamentoMensal();
            double total = f.calcularTotalDoPagamento(mensal);

            f.mostrarFinanciamento(mensal, total);
            contador++;

            totalImovel += f.getValorImovel();
            totalFinanciamento += total;
        }

        System.out.printf("O valor total dos imóveis é R$ %.2f%n", totalImovel);
        System.out.printf("O valor total dos financiamentos é R$ %.2f%n", totalFinanciamento);

    }
}


