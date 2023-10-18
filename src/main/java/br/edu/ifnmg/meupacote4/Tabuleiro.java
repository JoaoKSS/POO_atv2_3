/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.meupacote4;

/**
 *
 * @author joaok
 */
public class Tabuleiro {

    private int tamanho;
    private int[][] tabuleiro;

    public Tabuleiro(int tamanho) {
        this.tamanho = tamanho;
        this.tabuleiro = new int[tamanho][tamanho];
        inicializarAcessibilidades();
    }

    private void inicializarAcessibilidades() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if ((i == 0 || i == 7) && (j == 0 || j == 7)) {
                    tabuleiro[i][j] = 2;
                } else if ((i == 1 || i == 6) && (j == 0 || j == 7)
                        || (i == 0 || i == 7) && (j == 1 || j == 6)) {
                    tabuleiro[i][j] = 3;
                } else if (i == 0 || i == 7 || j == 0 || j == 7) {
                    tabuleiro[i][j] = 4;
                } else {
                    tabuleiro[i][j] = 6;
                }
            }
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public void exibirTabuleiro() {
        for (int[] linha : this.tabuleiro) {
            for (int celula : linha) {
                System.out.print(celula + " ");
            }
            System.out.println();
        }
    }
}
