package Personagens;

import VantagensEFraquezas.Habilidade;

import java.util.ArrayList;

public class Guerreiro extends Personagem{
    private int quantidadeDeArmas;

    public Guerreiro(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade> habilidades, int quantidadeDeArmas) {
        super(nome, pontosVida, forca, defesa, habilidades, 0);
        this.quantidadeDeArmas = quantidadeDeArmas;
    }

    @Override
    public String toString() {
        return "\n------------- Dados De Personagem --------------\n" +
                    "\nNome = " + nome +
                    "\nClasse = Guerreiro" +
                    "\nPontosVida = " + pontosVida +
                    "\nForca = " + forca +
                    "\nDefesa = " + defesa +
                    "\nHabilidades = " + habilidades +
                    "\nPontos de Experiencia = " + pontosExperiencia;
        }

    public int getQuantidadeDeArmas() {
        return quantidadeDeArmas;
    }

    public void setQuantidadeDeArmas(int quantidadeDeArmas) {
        this.quantidadeDeArmas = quantidadeDeArmas;
    }
}


