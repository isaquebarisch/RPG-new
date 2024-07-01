import Combates.Batalha;
import Inimigos.Inimigo;
import Jogo.Jogo;
import Personagens.Personagem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.printf("Bem Vindo ao RPG!");
        System.out.printf("\nCrie Primeiro um Personagem!");
        Jogo jogo1 = new Jogo();
        Personagem player1 = jogo1.criarPersonagem();



        System.out.printf("\nCrie agora um Inimigo!");
        Inimigo inimigo1 = jogo1.criarInimigo();


        Batalha batalha1 = new Batalha();
        batalha1.ordemTurnos(player1, inimigo1, jogo1);


        Scanner scan = new Scanner(System.in);
        System.out.println("\nDeseja continuar o jogo?" + "\n1 - Sim" + "\n2 - Não");
        int op;
        op = scan.nextInt();
        switch (op) {

            case 1:
                while (op == 1) {

                    System.out.printf("\nCrie agora um outro Inimigo!");
                    Inimigo inimigo2 = jogo1.criarInimigo();


                    Batalha batalha2 = new Batalha();
                    batalha1.ordemTurnos(player1, inimigo2, jogo1);

                    System.out.println("\nDeseja continuar o jogo?" + "\n1 - Sim" + "\n2 - Não");
                    op = scan.nextInt();

                }
                break;
            case 2:
                return;

        }


//


    }
}