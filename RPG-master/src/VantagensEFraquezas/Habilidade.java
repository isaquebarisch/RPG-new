package VantagensEFraquezas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Habilidade {

    private String nome;
    private String tipo;
    private int danoBase;

    public Habilidade(String nome, String tipo, int danoBase) {
        this.nome = nome;
        this.tipo = tipo;
        this.danoBase = danoBase;
    }

    public Habilidade() {

        Scanner scan = new Scanner(System.in);
        System.out.printf("\nQual o tipo de Habilidade?: " + "\n1 - Fogo" + "\n2 - Gelo" + "\n3 - Agua" + "\n4 - Eletricidade" + "\n5 - Ar\n");
        int opTipo = 0;
        opTipo = scan.nextInt();
        switch (opTipo) {

            case 1: {
                int opNome;
                this.setTipo("Fogo");
                System.out.printf("\nQual o nome da Habilidade?: " + "\n1 - Lanca-Chamas" + "\n2 - Bola-de-Fogo\n");
                opNome = scan.nextInt();

                switch (opNome) {
                    case 1: {
                        this.setNome("Lanca-Chamas");
                        this.setDanoBase(2);
                        break;
                    }

                    case 2: {
                        this.setNome("Bola-de-Fogo");
                        this.setDanoBase(3);
                        break;
                    }
                }
            }
            break;
            case 2: {
                int opNome = 0;
                this.setTipo("Gelo");
                System.out.printf("\nQual o nome da Habilidade?: " + "\n1 - Frio-Extremo" + "\n2 - Jogar-Neve\n");
                opNome = scan.nextInt();
                switch (opNome) {
                    case 1:
                        this.setNome("Frio-Extremo");
                        this.setDanoBase(2);
                        break;

                    case 2:
                        this.setNome("Jogar-Neve");
                        this.setDanoBase(3);
                        break;
                }
            }
            break;

            case 3: {
                int opNome = 0;
                this.setTipo("Água");
                System.out.printf("\nQual o nome da Habilidade?: " + "\n1 - Agua-Torrente" + "\n2 - Agua-Pesada\n");
                opNome = scan.nextInt();
                switch (opNome) {
                    case 1:
                        this.setNome("Agua-Torrente");
                        this.setDanoBase(3);
                        break;

                    case 2:
                        this.setNome("Agua-Pesada");
                        this.setDanoBase(2);
                        break;
                }
            }
            break;

            case 4: {
                int opNome = 0;
                this.setTipo("Eletricidade");
                System.out.printf("\nQual o nome da Habilidade?: " + "\n1 - Alta-Voltagem\n");
                opNome = scan.nextInt();
                switch (opNome) {
                    case 1:
                        this.setNome("Alta-Voltagem");
                        this.setDanoBase(2);
                        break;

                }
            }
            break;
            case 5: {
                int opNome = 0;
                this.setTipo("Ar");
                System.out.printf("\nQual o nome da Habilidade?: " + "\n1 - Furacao" + "\n2 - Vento-Forte\n");
                opNome = scan.nextInt();
                switch (opNome) {
                    case 1:
                        this.setNome("Furacao");
                        this.setDanoBase(3);
                        break;

                    case 2:
                        this.setNome("Vento-Forte");
                        this.setDanoBase(2);
                        break;
                }

            }
            break;

        }



    }



    @Override
    public String toString() {
        return "Habilidade{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", danoBase=" + danoBase +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }
}





