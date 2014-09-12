/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transposicao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charleshenriqueportoferreira
 */
public class Transposicao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nomeArquivo = args[0];
        String arquivoModificicado = "";
        try {
            arquivoModificicado = lerArquivo(nomeArquivo);
        } catch (IOException ex) {
            Logger.getLogger(Transposicao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            printFile(args[1], arquivoModificicado);
        } catch (IOException ex) {
            Logger.getLogger(Transposicao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String lerArquivo(String filePath) throws FileNotFoundException, IOException {
        StringBuilder linha = new StringBuilder();
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            ArrayList<String[]> arrays = new ArrayList<>();

            while (br.ready()) {
                String linhaLida = br.readLine();
                arrays.add(linhaLida.split(","));

            }
            br.close();
            fr.close();
            int tamanho = arrays.get(0).length;
            for (int i = 0; i < tamanho; i++) {
                int a = 0;
                for (int j = 0; j < arrays.size(); j++) {
                    String array[] = arrays.get(j);
                    if (array[1].contains("?")) {
                        int b = 0;
                    }
                    if (array.length == tamanho) {
                        if (j > 0) {
                            linha.append(",");
                        }
                        linha.append(array[i]);
                        if (array[1].contains("?")) {
                            int b = 0;
                            System.out.println(linha);
                        }

                    }

                }

                linha.append("\n");
                //System.out.println(linha);
            }
        }
        return linha.toString();
    }

    public static void printFile(String fileName, String texto) throws IOException {
        try (FileWriter fw = new FileWriter(fileName); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(texto);
            bw.newLine();
            bw.close();
            fw.close();
        }
    }

}
