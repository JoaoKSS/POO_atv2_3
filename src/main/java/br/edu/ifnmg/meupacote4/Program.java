/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifnmg.meupacote4;

/**
 *
 * @author joaok
 */
public class Program {

    public static void main(String[] args) {
        int totalPasseiosCompletos = 0;
        int linIni = 7;
        int colIni = 2;
        for (int linhaInicial = linIni; linhaInicial < 8; linhaInicial++) {
            for (int colunaInicial = colIni; colunaInicial < 8; colunaInicial++) {
                Tabuleiro tabuleiro = new Tabuleiro(8);
                Cavalo cavalo = new Cavalo();
                int movimentos = cavalo.passeioDoCavalo(tabuleiro, linhaInicial, colunaInicial);
                System.out.println(" movimentos (" + linhaInicial + ", " + colunaInicial + ").");
                tabuleiro.exibirTabuleiro();
                if (movimentos == 64) {
                    totalPasseiosCompletos++;
                }
                System.out.println("-------------------------------------------");
            }
        }
        System.out.println("Total de passeios completos: " + totalPasseiosCompletos);

    }
}
