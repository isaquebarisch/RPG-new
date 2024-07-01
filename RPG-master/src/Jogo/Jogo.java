package Jogo;

import Combates.Batalha;
import Inimigos.Inimigo;
import Personagens.Arqueiro;
import Personagens.Guerreiro;
import Personagens.Mago;
import Personagens.Personagem;
import VantagensEFraquezas.Habilidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    private Personagem personagem;
    private Inimigo inimigo;

    private Random random = new Random();

    Scanner scan = new Scanner(System.in);

    public Jogo() {
    }

    public void listarDados(Personagem personagem, Inimigo inimigo) {

        System.out.printf(personagem.toString());
        System.out.printf(inimigo.toString());


    }
    public Personagem criarPersonagem() {

        String nome = null;
        String classe = null;

        System.out.printf("\nOlá, para criar o personagem, digite o Nome dele: ");
        nome = scan.next();

        int op = 0;
        System.out.printf("\nOlá, digite a Classe dele: " + "\n1 - Guerreiro" + "\n2 - Mago" + "\n3 - Arqueiro\n");
        op = scan.nextInt();

        switch(op) {

            case 1: {

                classe = "Guerreiro";
                Habilidade h1 = new Habilidade();
                ArrayList<Habilidade> habilidadesPersonagem = new ArrayList<>();
                habilidadesPersonagem.add(h1);
                personagem = (new Guerreiro(nome, 150, 10, 8,habilidadesPersonagem, 2));
            }
            break;

            case 2: {

                classe = "Mago";
                Habilidade h1 = new Habilidade();
                ArrayList<Habilidade> habilidadesPersonagem = new ArrayList<>();
                habilidadesPersonagem.add(h1);
                personagem = (new Mago(nome, 50, 8, 15,habilidadesPersonagem, 5));
            }
            break;

            case 3: {

                classe = "Arqueiro";
                Habilidade h1 = new Habilidade();
                ArrayList<Habilidade> habilidadesPersonagem = new ArrayList<>();
                habilidadesPersonagem.add(h1);
                personagem =(new Arqueiro(nome, 100, 15, 5,habilidadesPersonagem, 8));
            }
            break;


        }
        return personagem;
    }

    public Inimigo criarInimigo() {

        System.out.printf("\nQual o Tipo de Inimigo você deseja lutar?: ");
        System.out.println("\n1 - Animal " + "\n2 - Monstro " + "\n3 - Chefe");
        int opTipo, opNome = 0;
        String tipo, nome;
        opTipo = scan.nextInt();
        Inimigo inimigo = new Inimigo(null, 0, 0, 0, null, null, 0);

        switch (opTipo) {
            case 1: {
                tipo = "Animal";
                System.out.println("\nQuais desses Animais você deseja combater?" + "\n1 - Rato" + "\n2 - Gato" + "\n3 - Cavalo" + "\n4 - Leão");
                opNome = scan.nextInt();
                switch (opNome) {
                    case 1:
                        nome = "Rato";
                        Inimigo inimigo1 = new Inimigo(nome, 15, 4, 4, gerarHabilidadesAleatorias(), tipo, 5);
                        inimigo = inimigo1;
                        return inimigo;

                    case 2:
                        nome = "Gato";
                        inimigo1 = new Inimigo(nome, 15, 4, 4, gerarHabilidadesAleatorias(), tipo, 5);
                        inimigo = inimigo1;
                        return inimigo;

                    case 3:
                        nome = "Cavalo";
                        inimigo1 = new Inimigo(nome, 20, 4, 4, gerarHabilidadesAleatorias(), tipo, 8);
                        inimigo = inimigo1;
                        return inimigo;

                    case 4:
                        nome = "Leão";
                        inimigo1 = new Inimigo(nome, 25, 5, 4, gerarHabilidadesAleatorias(), tipo, 10);
                        inimigo = inimigo1;
                        return inimigo;

                }
            }
            break;
            case 2: {
                tipo = "Monstro";
                System.out.println("\nQuais desses monstros você deseja combater?" + "\n1 - Lagarto Gigante" + "\n2 - Dinossauro Mutante");
                opNome = 0;
                opNome = scan.nextInt();

                switch (opNome) {
                    case 1: {
                        nome = "Lagarto-Gigante";
                        Inimigo inimigo1 = new Inimigo(nome, 40, 10, 5, gerarHabilidadesAleatorias(), tipo, 15);
                        inimigo = inimigo1;
                        return inimigo;

                    }
                    case 2: {
                        nome = "Dinossauro-Mutante";
                        Inimigo inimigo1 = new Inimigo(nome, 50, 20, 5, gerarHabilidadesAleatorias(), tipo, 25);
                        inimigo = inimigo1;
                        return inimigo;

                    }
                }

            }
            break;
            case 3: {
                tipo = "Monstro";
                System.out.println("\nQuais desses Chefes você deseja combater?" + "\n1 - Darth Vader" + "\n2 - Bob Esponja");
                opNome = 0;
                opNome = scan.nextInt();

                switch (opNome) {
                    case 1: {
                        nome = "Darth Vader";
                        Inimigo inimigo1 = new Inimigo(nome, 70, 25, 10, gerarHabilidadesAleatorias(), tipo, 50);
                        inimigo = inimigo1;
                        return inimigo;


                    }
                    case 2: {
                        nome = "Bob Esponja";
                        Inimigo inimigo8 = new Inimigo(nome, 100, 35, 10, gerarHabilidadesAleatorias(), tipo, 100);
                        inimigo = inimigo8;
                        return inimigo;


                    }
                }
            }
            break;
        }
        return inimigo;
    }

    public ArrayList<Habilidade> gerarHabilidadesAleatorias () {
        Random random = new Random();
        ArrayList<Habilidade> habilidades = new ArrayList<>();

        String[] habTipos = {"Fogo", "Gelo", "Água", "Eletricidade", "Ar"};
        String habTipo = habTipos[random.nextInt(habTipos.length)];
        String[] habNomes;
        int danoBase = 0;

        switch (habTipo) {
            case "Fogo":
                habNomes = new String[]{"Lança-Chamas", "Bola-de-Fogo"};
                break;
            case "Gelo":
                habNomes = new String[]{"Frio-Extremo", "Lança-Neve"};
                break;
            case "Água":
                habNomes = new String[]{"Água-Torrente", "Água-Pesada"};
                break;
            case "Eletricidade":
                habNomes = new String[]{"Alta-Voltagem"};
                break;
            case "Ar":
                habNomes = new String[]{"Furacão", "Vento-Forte"};
                break;
            default:
                habNomes = new String[]{};
                break;
        }

        String habNome = habNomes[random.nextInt(habNomes.length)];

        switch (habNome) {
            case "Lança-Chamas":
            case "Frio-Extremo":
            case "Água-Torrente":
            case "Alta-Voltagem":
            case "Furacão":
                danoBase = 2;
                break;
            case "Bola-de-Fogo":
            case "Lança-Neve":
            case "Água-Pesada":
            case "Vento-Forte":
                danoBase = 3;
                break;
        }

        Habilidade habilidadeI = new Habilidade(habNome, habTipo, danoBase);
        habilidades.add(habilidadeI);

        return habilidades;
    }



    public void realizarBatalha() {
        Batalha batalha1 = new Batalha();

    }

}
