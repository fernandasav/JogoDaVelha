import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            Matriz[][] jogoDaVelha = new Matriz[3][3];
            Matriz jogo = new Matriz();
            String posicao;
            int valida = 0, Jogadas = 0, jogarNovamente;
            String nome2;

            System.out.println("------Jogo da Velha da B3------");
            System.out.println("   ");
            jogo.Mostrar();
            System.out.println("Jogador 1, digite seu nome:");
            String nome1 = scanner.next();
            System.out.println("O jogador 1 se chama: " + nome1 + " e joga com o 'X'");
            System.out.println("Jogador 2, digite seu nome:");
            nome2 = scanner.next();
            System.out.println("O jogador 2 se chama: " + nome2 + " e joga com o 'O'");

            while (true) {
                do {
                    jogo.Mostrar();
                    System.out.println("Jogador 1 " + nome1 + " informe uma posição: ");
                    posicao = scanner.next();
                    while (!jogo.JogadasValidas(posicao)) {
                        System.out.println("Jogada inválida, tente novamente.");
                        System.out.println("Jogador 1, informe uma posição: ");
                        posicao = scanner.next();
                        valida = 0;
                    }
                    jogo.Jogada(posicao, "X");
                    valida = 1;
                } while (valida == 0);

                Jogadas++;
                valida = 0;
                if (!jogo.Ganhou(Jogadas).equals("null")) {
                    break;
                }

                do {
                    jogo.Mostrar();
                    System.out.println("Jogador 2 " + nome2 + " informe uma posição: ");
                    posicao = scanner.next();
                    while (!jogo.JogadasValidas(posicao)) {
                        System.out.println("Jogada inválida, tente novamente.");
                        System.out.println("Jogador 2, informe uma posição: ");
                        posicao = scanner.next();
                        valida = 0;
                    }
                    jogo.Jogada(posicao, "O");
                    valida = 1;
                } while (valida == 0);

                Jogadas++;
                valida = 0;
                if (!jogo.Ganhou(Jogadas).equals("null")) {
                    break;
                }
            }
            if (jogo.Ganhou(Jogadas).equals("EMPATE")) {
                System.out.println("Empate!");
            } else {
                System.out.println("O " + jogo.Ganhou(Jogadas) + " venceu!!!");
            }
            System.out.println("Deseja jogar novamente?");
            while (true) {
                Scanner input = new Scanner(System.in);
                try {
                    System.out.println("1 = sim");
                    System.out.println("2 = não");
                    jogarNovamente = input.nextInt();
                    if (jogarNovamente == 1 || jogarNovamente == 2) {
                        break;
                    }
                    System.err.println("Resposta inválida. Digite novamente: ");
                } catch (InputMismatchException error) {
                    System.err.println("Resposta inválida. Digite 1 = sim ou 2 = nao");
                }
            }

            if (jogarNovamente == 2) {
                break;
            }
        } while(true);
        scanner.close();
        System.out.println("Obrigada por jogar!");
    }
}