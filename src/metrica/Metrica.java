/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrica;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Lucas Gabriel de Souza Dutra
 */
public class Metrica {

    public static final int TOTAL = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        String nomes[] = new String[TOTAL];
        int[] nascimento = new int[TOTAL];
        double alturas[] = new double[TOTAL];
        double[] peso = new double[TOTAL];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < TOTAL; i++) {
            do {
                System.out.println("Digite o nome do ID " + (i + 1) + ". Não é permitido nomes vazios");
                nomes[i] = scanner.nextLine();
            } while (nomes[i].trim().isEmpty());
            do {
                System.out.println("Digite a sua idade: Não é permitido idades negativas");
                nascimento[i] = ano - scanner.nextInt();
            } while (nascimento[i] > ano);
            do {
                System.out.println("Digite o seu peso, não é permitido peso menor que 0");
                peso[i] = scanner.nextDouble();
            } while (peso[i] < 0);
            do {
                System.out.println("Digite  a sua altura: Não é permitido altura negativa ou nula");
                alturas[i] = scanner.nextDouble();
            } while (alturas[i] <= 0);
            scanner.nextLine();
        }
        System.out.printf("%2s %20s %10s %10s %10s %5s %15s \n", "ID", "Nome", "Nascimento", "Altura", "Peso", "IMC", "Classificação");
        for (int i = 0; i < TOTAL; i++) {
            double imc = calcularIMC(alturas[i], peso[i]);
            System.out.printf("%d %20s %10d %10.2f %10.2f %8.2f %15s\n", i + 1, nomes[i], nascimento[i], alturas[i], peso[i], imc, classificacao(imc));
        }
    }

    /**
     *Método para verificar o IMC
     * 
     * @param altura
     * @param peso
     * @return
     */
    public static double calcularIMC(double altura, double peso) {
        return peso / Math.pow(altura, 2);
    }

    /**
     * Metodo para recuperar a classificação
     *
     * @param imc
     * @return
     */
    public static String classificacao(double imc) {
        if (imc <= 18.5) {
            return "Abaixo do peso";
        } else {
            if (imc < 25) {
                return "Peso Ideal";
            } else {
                if (imc < 30) {
                    return "Levemente acima o peso";
                } else {
                    if (imc < 35) {
                        return "Obesidade I";
                    } else {
                        return "Obesidade II";
                    }
                }
            }
        }
    }

}
