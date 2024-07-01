package Personagens;

import VantagensEFraquezas.Habilidade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Personagem {
    protected String nome;
    protected int pontosVida;
    protected int forca;
    protected int defesa;
    protected ArrayList<Habilidade> habilidades;
    private Map<String, String> vantagens;
    private Map<String, String > fraquezas;
    protected int pontosExperiencia;
    protected boolean envenenado;
    protected boolean atordoado;
    protected boolean queimado;
    protected int dormindo;

    private void listaDeVantagensEFraquezas() {

        vantagens.put("Fogo","Gelo");
        fraquezas.put("Fogo", "Água");

        vantagens.put("Gelo","Água");
        fraquezas.put("Gelo", "Fogo");

        vantagens.put("Elétrico","Água");
        fraquezas.put("Elétrico", "Ar");

        vantagens.put("Ar","Elétrico");
        fraquezas.put("Ar", "Gelo");

    }

    public Personagem(String nome, int pontosVida, int forca, int defesa, ArrayList<Habilidade> habilidades, int xp) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.forca = forca;
        this.defesa = defesa;
        this.habilidades = habilidades;
        this.vantagens = new HashMap<>();
        this.fraquezas = new HashMap<>();
        this.pontosExperiencia = xp;
        this.envenenado = false;
        this.atordoado = false;
        this.queimado = false;
        this.dormindo = 0;
        listaDeVantagensEFraquezas();
    }

    public int calcularDano(Habilidade habilidade, Personagem atingido) {

        String tipoHabilidade = habilidade.getTipo();

        int dano = habilidade.getDanoBase();

        if (vantagens.containsKey(tipoHabilidade)) {
            String fraquezaAtingido = atingido.getFraquezas().toString();
            if (vantagens.get(tipoHabilidade).equals(fraquezaAtingido)) {
                dano = dano * 2;
            }
            
        }

        return dano;

    }


    @Override
    public String toString() {
        return "\n------------- Dados De Personagem --------------\n" +
                "\nNome = " + nome +
                "\nPontosVida = " + pontosVida +
                "\nForca = " + forca +
                "\nDefesa = " + defesa +
                "\nHabilidades = " + habilidades +
                "\nVantagens = " + vantagens +
                "\nFraquezas = " + fraquezas +
                "\nPontos de Experiencia = " + this.getPontosExperiencia();
    }

    public boolean isEnvenenado() {
        return envenenado;
    }

    public void setEnvenenado(boolean envenenado) {
        this.envenenado = envenenado;
    }

    public boolean isAtordoado() {
        return atordoado;
    }

    public void setAtordoado(boolean atordoado) {
        this.atordoado = atordoado;
    }

    public boolean isQueimado() {
        return queimado;
    }

    public void setQueimado(boolean queimado) {
        this.queimado = queimado;
    }

    public int getDormindo() {
        return dormindo;
    }

    public void setDormindo(int dormindo) {
        this.dormindo = dormindo;
    }

    public int getPontosExperiencia() {
        return pontosExperiencia;
    }

    public void setPontosExperiencia(int pontosExperiencia) {
        this.pontosExperiencia = pontosExperiencia;
    }

    public ArrayList<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public Map<String, String> getVantagens() {
        return vantagens;
    }

    public void setVantagens(Map<String, String> vantagens) {
        this.vantagens = vantagens;
    }

    public Map<String, String> getFraquezas() {
        return fraquezas;
    }

    public void setFraquezas(Map<String, String> fraquezas) {
        this.fraquezas = fraquezas;
    }
}
