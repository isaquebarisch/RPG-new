package Personagens;

import VantagensEFraquezas.Habilidade;

import java.util.ArrayList;

public class Arqueiro extends Personagem{

    private int destreza;

    public Arqueiro(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade> habilidades, int destreza) {
        super(nome, pontosVida, forca, defesa, habilidades,0);
        this.destreza = destreza;
    }

    @Override
    public String toString() {
        return "\n------------- Dados De Personagem --------------\n" +
                "\nNome = " + nome +
                "\nClasse = Arqueiro" +
                "\nPontosVida = " + pontosVida +
                "\nForca = " + forca +
                "\nDefesa = " + defesa +
                "\nHabilidades = " + habilidades +
                "\nPontos de Experiencia = " + pontosExperiencia +
                "\nDestreza = " + destreza;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
}
