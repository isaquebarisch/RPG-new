package Inimigos;

import Personagens.Personagem;
import VantagensEFraquezas.Habilidade;

import java.util.ArrayList;

public class Inimigo extends Personagem {

    private String tipo;
    private int recompensaXP;

    public Inimigo(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade> habilidades, String tipo, int recompensaXP) {
        super(nome, pontosVida, forca, defesa, habilidades,0);
        this.tipo = tipo;
        this.recompensaXP = recompensaXP;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRecompensaXP() {
        return recompensaXP;
    }

    public void setRecompensaXP(int recompensaXP) {
        this.recompensaXP = recompensaXP;
    }

    @Override
    public String toString() {
        return "\n------------Dados do Inimigo---------------\n" +
                "\nTipo = " + tipo +
                "\nRecompensa XP = " + recompensaXP +
                "\nNome = " + nome +
                "\nPontos de Vida = " + pontosVida +
                "\nForca = " + forca +
                "\nDefesa = " + defesa +
                "\nHabilidades = " + habilidades;
    }
}
