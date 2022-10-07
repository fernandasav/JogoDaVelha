
public class Matriz {
    private String[][] jogoDaVelha = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
    public String Mostrar() {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                if (c == 2){
                    System.out.printf(jogoDaVelha[l][c] );
                } else {
                    System.out.printf(jogoDaVelha[l][c] + " | " );
                }
            }
            System.out.println("");
            System.out.println("---------");
        }
        return null;
    }
    public boolean JogadasValidas(String p) {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                if (jogoDaVelha[l][c].equals(p))
                    return true;
            }
        }
        return false;
    }
    public void Jogada(String p, String j){
        if (p.equals("1"))
            jogoDaVelha[0][0] = j;
        else if (p.equals("2"))
            jogoDaVelha[0][1] = j;
        else if (p.equals("3"))
            jogoDaVelha[0][2] = j;
        else if (p.equals("4"))
            jogoDaVelha[1][0] = j;
        else if (p.equals("5"))
            jogoDaVelha[1][1] = j;
        else if (p.equals("6"))
            jogoDaVelha[1][2] = j;
        else if (p.equals("7"))
            jogoDaVelha[2][0] = j;
        else if (p.equals("8"))
            jogoDaVelha[2][1] = j;
        else if (p.equals("9"))
            jogoDaVelha[2][2] = j;
    }
    public String Ganhou (int jogadas) {
        String[] T = new String[8];
        String vencedor = "null";
        if (jogadas == 9) {
            vencedor = "EMPATE";
        }

        T[0] = jogoDaVelha[0][0] + jogoDaVelha[0][1] + jogoDaVelha[0][2];
        T[1] = jogoDaVelha[1][0] + jogoDaVelha[1][1] + jogoDaVelha[1][2];
        T[2] = jogoDaVelha[2][0] + jogoDaVelha[2][1] + jogoDaVelha[2][2];
        T[3] = jogoDaVelha[0][0] + jogoDaVelha[1][0] + jogoDaVelha[2][0];
        T[4] = jogoDaVelha[0][1] + jogoDaVelha[1][1] + jogoDaVelha[2][1];
        T[5] = jogoDaVelha[0][2] + jogoDaVelha[1][2] + jogoDaVelha[2][2];
        T[6] = jogoDaVelha[0][0] + jogoDaVelha[1][1] + jogoDaVelha[2][2];
        T[7] = jogoDaVelha[0][2] + jogoDaVelha[1][1] + jogoDaVelha[2][0];

        for (int i = 0; i < T.length; i++) {
            if (T[i].equals("XXX")) {
                vencedor = "Jogador 1";
            } else if (T[i].equals("OOO")) {
                vencedor = "Jogador 2";
            }
        }
        return vencedor;
    }

}
