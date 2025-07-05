/*
ATIVIDADE SOMATIVA DE POO - TURMA: 22
NOME: LUCAS SCHNEIDER CORDEIRO
 */

package Main;

import Util.InterfaceUsuario;
import Modelo.Financiamento;
import java.util.ArrayList;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();
        InterfaceUsuario iu = new InterfaceUsuario();

        String arquivo = "financiamentos.dat";

        try {
            iu.iniciarSistema(listaFinanciamentos, iu, arquivo);
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o sistema de financiamentos:" + e.getMessage());
        }

        if (!listaFinanciamentos.isEmpty()) {
            // Salvar lista em arquivo
            try {
                FileOutputStream fos = new FileOutputStream(arquivo);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(listaFinanciamentos);
                oos.close();
                fos.close();
                System.out.println("Lista salva com sucesso!");

            } catch (IOException e) {
                System.out.println("Erro ao salvar a lista: " + e.getMessage());
            }

            // Ler lista do arquivo
            try {
                iu.lerListaDoArquivo(arquivo);
            } catch (Exception e) {
                System.out.println("Erro ao ler a lista: " + e.getMessage());
            }

            // Salvar lista de financiamentos em .txt
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter("FinanciamentosArquivo.txt", true))) {
                int cont = 1;
                for (Financiamento f : listaFinanciamentos) {
                    escritor.write("-=-=-=-= Financiamentos 1" + cont + "-=-=-=-=\n");
                    escritor.write(f.toString());
                    escritor.newLine();
                }
            } catch (IOException e) {
                System.out.println("Erro ao salvar no arquivo .txt: " + e.getMessage());
            }
        } else {
            System.out.println("Nenhum novo financiamento foi adicionado. Nada foi salvo.");
        }
    }
}