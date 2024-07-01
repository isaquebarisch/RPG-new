package Personagens;

import VantagensEFraquezas.Habilidade;

import java.util.ArrayList;

public class Mago extends Personagem{

    private int pontosMagia;

    public Mago(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade> habilidades, int pontosMagia) {
        super(nome, pontosVida, forca, defesa, habilidades,0);
        this.pontosMagia = pontosMagia;
    }

    @Override
    public String toString() {
        return "\n------------- Dados De Personagem --------------\n" +
                "\nNome = " + nome +
                "\nClasse = Mago" +
                "\nPontosVida = " + pontosVida +
                "\nForca = " + forca +
                "\nDefesa = " + defesa +
                "\nHabilidades = " + habilidades +
                "\nPontos de Experiencia = " + pontosExperiencia +
                "\nPontos de Magia = " + pontosMagia;
    }


    public int getPontosMagia() {
        return pontosMagia;
    }

    public void setPontosMagia(int pontosMagia) {
        this.pontosMagia = pontosMagia;
    }
}
