package Combates;

import Inimigos.Inimigo;
import Jogo.Jogo;
import Personagens.Mago;
import Personagens.Personagem;
import VantagensEFraquezas.Habilidade;

import java.util.Random;
import java.util.Scanner;

public class Batalha {

    private int turno;
    private Personagem p;
    private Inimigo i;
    private int danoVeneno = 2;
    private int danoQueimado = 4;
    private Random random = new Random();

    public Batalha(Personagem p1, Inimigo i1) {
        this.p = p1;
        this.i = i1;
        this.turno = 1;
        this.random = new Random();
    }


    public void ordemTurnos(Personagem personagem, Inimigo inimigo, Jogo jogo) {


        Scanner scan = new Scanner(System.in);

        // Se 1 - Turno do personagem, 2 - turno do inimigo

        this.setTurno(1);
        this.p = personagem;
        this.i = inimigo;

        while (p.getPontosVida() > 0 && i.getPontosVida() > 0) {
            if (this.getTurno() == 1) {
                System.out.printf("\n--------------A vez é do Personagem!------------------");
                if (p.isAtordoado()) {
                    System.out.println("O Personagem está atordoado e perdou o turno!");
                    p.setAtordoado(false);
                } else if (p.getDormindo() > 0) {
                    System.out.println("O Personagem está dormindo e perdou o turno!");
                } else {
                    System.out.printf("\nO que deseja fazer?" + "\n1 - Atacar" + "\n2 - Defender" + "\n3 - Fugir" + "\n4 - Usar Magia" + "\n5 - Listar Dados\n");
                    int op = 0;
                    op = scan.nextInt();
                    switch (op) {
                        case 1:
                            atacar(p, i);
                            break;

                        case 2:
                            defender(p, i);
                            break;

                        case 3:
                            fugir();
                            break;

                        case 4:
                            if (p instanceof Mago) {
                                Mago mago = (Mago) p;
                                usarMagia(mago, inimigo);
                            } else {
                                System.out.printf("\nEste personagem não é mago.\n");
                            }
                            break;

                        case 5:
                            jogo.listarDados(personagem, inimigo);
                            break;

                        default:
                            System.out.println("\nOpção Inválida!\n");
                            break;
                    }

                }
                aplicarOsEfeitosEmPersonagem(p);
                this.setTurno(2);
            }


            else if (this.getTurno() == 2) {
                System.out.printf("\n-----------A vez é do Inimigo!-------------");
                if (i.isAtordoado()) {
                    System.out.println("O Inimigo está atordoado e perdou o turno!");
                    i.setAtordoado(false);
                } else if (i.getDormindo() > 0) {
                    System.out.println("O Inimigo está dormindo e perdou o turno!");
                } else {

                    System.out.printf("\nO que Inimigo deseja fazer?" + "\n1 - Atacar" + "\n2 - Defender" + "\n3 - Fugir\n" + "4 - Listar Dados\n");
                    int op = 0;
                    op = scan.nextInt();
                    switch (op) {
                        case 1:
                            atacar(i, p);
                            break;

                        case 2:
                            defender(i, p);
                            break;

                        case 3:
                            fugir();
                            break;

                        case 4:
                            jogo.listarDados(personagem, inimigo);
                            break;

                        default:
                            System.out.println("\nOpção Inválida!\n");
                            break;


                    }

                }

                aplicarOsEfeitosEmPersonagem(i);
                this.setTurno(1);
            }

            if(i.getPontosVida()<=0)

            {
                System.out.println("\n" + i.getNome() + " foi derrotado!!");
                p.setPontosExperiencia(p.getPontosExperiencia() + i.getRecompensaXP());
                System.out.printf("\n" + p.getNome() + " ganhou " + i.getRecompensaXP() + " pontos de XP!\n");
                System.out.println("\nExperiencia = " + p.getPontosExperiencia());
            }
        }



        if(p.getPontosVida()<=0)

    {
        System.out.println("\n" + p.getNome() + " foi derrotado!!");
        p.setPontosExperiencia(0);
        return;
    }

}


    public void atacar(Personagem atacante, Personagem defensor) {


        int dano = 0;

        if (atacante.getForca() > defensor.getDefesa()) {
            if (!atacante.getHabilidades().isEmpty()) {
                Habilidade habilidade = atacante.getHabilidades().get(0);
                int danoHabilidade = atacante.calcularDano(habilidade, defensor);
                dano = Math.abs(atacante.getForca() - defensor.getDefesa()) + danoHabilidade;

                String[] efeitos = {"envenenado", "atordoado", "queimado", "dormindo"};
                String aleatorio = efeitos[random.nextInt(efeitos.length)];
                colocarEfeito(aleatorio, defensor);
            }
            else {
                dano = 0;
            }

        }


        defensor.setPontosVida(defensor.getPontosVida() - dano);
        System.out.printf("\nDano feito de " + dano + " em " + defensor.getNome());
        System.out.printf("\nPontos de Vida de " + defensor.getNome() + " : " + defensor.getPontosVida());

    }

    public void defender(Personagem defensor, Personagem atacante) {

        int forca = atacante.getForca();
        int defesa = defensor.getDefesa();
        int dano = (forca - defesa) / 2;
        if (dano < 0) {
            dano = 0;
        }
        defensor.setPontosVida(defensor.getPontosVida() - dano);
        System.out.printf("\n" + defensor.getNome() + " defendeu o ataque de " + atacante.getNome() + " e sofreu " + dano + " de dano!");
        System.out.printf("\nPontos de Vida de " + defensor.getNome() + " : " + defensor.getPontosVida());



    }

    public void fugir() {

        System.out.printf("\nO Personagem fugiu!");

    }

    public void usarMagia(Mago mago, Inimigo inimigo) {

        int danoMagia = 0;


        if (mago.getPontosMagia() > inimigo.getDefesa()) {
            danoMagia = mago.getPontosMagia() - inimigo.getDefesa();
        }
        else {
            System.out.printf("\nNão houve dano!");
            danoMagia = 0;
        }

        inimigo.setPontosVida(inimigo.getPontosVida() - danoMagia);
        System.out.printf("\nO Mago usou a magia! O dano final foi de " + danoMagia + " em " + inimigo.getNome());


    }

    public void aplicarOsEfeitosEmPersonagem (Personagem personagem){
        if (personagem.isEnvenenado()) {
            personagem.setPontosVida(personagem.getPontosVida() - this.getDanoVeneno());
            System.out.printf("\n" + personagem.getNome() + " recebeu " + this.getDanoVeneno() + " danos de veneno!");
        }

        if (personagem.isQueimado()) {
            personagem.setPontosVida(personagem.getPontosVida() - this.getDanoQueimado());
            System.out.printf("\n" + personagem.getNome() + " recebeu " + this.getDanoQueimado() + " danos de queimadura!");
        }

        if (personagem.getDormindo() > 0) {
            personagem.setDormindo(personagem.getDormindo() - 1);
            System.out.println("\n" + personagem.getNome() + " está dormindo!");
        }
    }
    public void colocarEfeito (String efeito, Personagem alvo) {
        switch (efeito.toLowerCase()) {
            case "envenenado":
                alvo.setEnvenenado(true);
                System.out.println("\n" + alvo.getNome() + " foi envenenado!");
                break;

            case "atordoado":
                alvo.setAtordoado(true);
                System.out.println("\n" + alvo.getNome() + " foi atordoado!");
                break;

            case "queimado":
                alvo.setQueimado(true);
                System.out.println("\n" + alvo.getNome() + " foi queimado!");
                break;

            case "dormindo":
                int turnos = random.nextInt(3) + 1;
                alvo.setDormindo(turnos);
                System.out.println("\n" + alvo.getNome() + " vai estar dormindo por " + turnos + " turnos...");
                break;
        }
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getDanoVeneno() {
        return danoVeneno;
    }

    public void setDanoVeneno(int danoVeneno) {
        this.danoVeneno = danoVeneno;
    }

    public int getDanoQueimado() {
        return danoQueimado;
    }

    public void setDanoQueimado(int danoQueimado) {
        this.danoQueimado = danoQueimado;
    }

    public Personagem getP() {
        return p;
    }

    public void setP(Personagem p) {
        this.p = p;
    }

    public Inimigo getI() {
        return i;
    }

    public void setI(Inimigo i) {
        this.i = i;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Batalha() {
    }


}
