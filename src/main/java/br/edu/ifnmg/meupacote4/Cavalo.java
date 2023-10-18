/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifnmg.meupacote4;

/**
 *
 * @author joaok
 */
public class Cavalo {

    private int[] horizontal = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] vertical = {-1, -2, -2, -1, 1, 2, 2, 1};

    public int passeioDoCavalo(Tabuleiro tabuleiro, int linha, int coluna) {
        int contadorMovimentos = 1;
        tabuleiro.getTabuleiro()[linha][coluna] = contadorMovimentos;

        for (int i = 1; i < 64; i++) {
            int linhaAtual = linha;
            int colunaAtual = coluna;
            int minAcessibilidade = 8; // inicialmente, o máximo de acessibilidade

            int[] acessibilidades = new int[8];
            for (int j = 0; j < 8; j++) {
                int linhaTeste = linhaAtual + vertical[j];
                int colunaTeste = colunaAtual + horizontal[j];
                acessibilidades[j] = calcularAcessibilidade(tabuleiro, linhaTeste, colunaTeste);
            }

            for (int j = 0; j < 8; j++) {
                int linhaTeste = linhaAtual + vertical[j];
                int colunaTeste = colunaAtual + horizontal[j];
                if (linhaTeste >= 0 && linhaTeste < tabuleiro.getTamanho() && colunaTeste >= 0
                        && colunaTeste < tabuleiro.getTamanho() && tabuleiro.getTabuleiro()[linhaTeste][colunaTeste] == 0
                        && acessibilidades[j] < minAcessibilidade) {
                    minAcessibilidade = acessibilidades[j];
                    linha = linhaTeste;
                    coluna = colunaTeste;
                }
            }
            contadorMovimentos++;
            tabuleiro.getTabuleiro()[linha][coluna] = contadorMovimentos;
            atualizarAcessibilidades(tabuleiro, linha, coluna);
        }
        return contadorMovimentos;
    }

    private int calcularAcessibilidade(Tabuleiro tabuleiro, int linha, int coluna) {
        int acessibilidade = 0;
        for (int j = 0; j < 8; j++) {
            int linhaTeste = linha + vertical[j];
            int colunaTeste = coluna + horizontal[j];
            if (linhaTeste >= 0 && linhaTeste < tabuleiro.getTamanho() && colunaTeste >= 0
                    && colunaTeste < tabuleiro.getTamanho() && tabuleiro.getTabuleiro()[linhaTeste][colunaTeste] == 0) {
                acessibilidade++;
            }
        }
        return acessibilidade;
    }

    private void atualizarAcessibilidades(Tabuleiro tabuleiro, int linha, int coluna) {
        for (int j = 0; j < 8; j++) {
            int linhaTeste = linha + vertical[j];
            int colunaTeste = coluna + horizontal[j];
            if (linhaTeste >= 0 && linhaTeste < tabuleiro.getTamanho() && colunaTeste >= 0
                    && colunaTeste < tabuleiro.getTamanho() && tabuleiro.getTabuleiro()[linhaTeste][colunaTeste] == 0) {
                tabuleiro.getTabuleiro()[linhaTeste][colunaTeste]--;
            }
        }
    }
}
