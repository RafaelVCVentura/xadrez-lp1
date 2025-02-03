import java.util.ArrayList;

public class Bispo extends Peca {

    private Tabuleiro tabuleiro;
    
    public Bispo (Casa casa, int tipo, Tabuleiro tabuleiro) {
        super(casa, tipo);
        this.tabuleiro = tabuleiro;
    }

    public void mover (Casa destino) {
        ArrayList<Casa> movimentosValidos = movimentosValidos();
        for (int i = 0; i < movimentosValidos.size(); i++) {
            if (destino.getX() == movimentosValidos.get(i).getX() && destino.getY() == movimentosValidos.get(i).getY()) {
                casa.removerPeca();
                destino.colocarPeca(this);
                casa = destino;
            }
        }
    }

    private ArrayList<Casa> movimentosValidos () {
        ArrayList<Casa> movimentosValidos = new ArrayList<Casa>();
        int x = casa.getX();
        int y = casa.getY();
        
        //Valida movimentos para a diagonal superior direita (linhas e colunas crescentes)
        int j = y + 1;
        for (int i = x + 1; i <= 7 && j <= 7; i++) {
            Casa destino = tabuleiro.getCasa(i, j);
            if (!(destino.possuiPeca())) {
                movimentosValidos.add(destino);
            }
            else {
                if (validaMovimentoDeCaptura(movimentosValidos, destino)) {
                    return movimentosValidos;
                }
                if (this.getTipo() <= 5 && destino.getPeca().getTipo() <= 5 || this.getTipo() >= 6 && destino.getPeca().getTipo() >= 6) {
                    return movimentosValidos;
                }
            }
            j++;
        }

        //Valida movimentos para a diagonal inferior direita (linhas crescentes e colunas decrescentes)
        j = y - 1;
        for (int i = x + 1; i <= 7 && j >= 0; i++) {
            Casa destino = tabuleiro.getCasa(i, j);
            if (!(destino.possuiPeca())) {
                movimentosValidos.add(destino);
            }
            else {
                if (validaMovimentoDeCaptura(movimentosValidos, destino)) {
                    return movimentosValidos;
                }
                if (this.getTipo() <= 5 && destino.getPeca().getTipo() <= 5 || this.getTipo() >= 6 && destino.getPeca().getTipo() >= 6) {
                    return movimentosValidos;
                }
            }
            j--;
        }

        //Valida movimentos para a diagonal superior esquerda (linhas decrescentes e colunas crescentes)
        j = y + 1;
        for (int i = x - 1; i >= 0 && j <= 7; i--) {
            Casa destino = tabuleiro.getCasa(i, j);
            if (!(destino.possuiPeca())) {
                movimentosValidos.add(destino);
            }
            else {
                if (validaMovimentoDeCaptura(movimentosValidos, destino)) {
                    return movimentosValidos;
                }
                if (this.getTipo() <= 5 && destino.getPeca().getTipo() <= 5 || this.getTipo() >= 6 && destino.getPeca().getTipo() >= 6) {
                    return movimentosValidos;
                }
            }
            j++;
        }

        //Valida movimentos para a diagonal inferior esquerda (linhas e colunas decrescentes)
        j = y - 1;
        for (int i = x - 1; i >= 0 && j >= 0; i--) {
            Casa destino = tabuleiro.getCasa(i, j);
            if (!(destino.possuiPeca())) {
                movimentosValidos.add(destino);
            }
            else {
                if (validaMovimentoDeCaptura(movimentosValidos, destino)) {
                    return movimentosValidos;
                }
                if (this.getTipo() <= 5 && destino.getPeca().getTipo() <= 5 || this.getTipo() >= 6 && destino.getPeca().getTipo() >= 6) {
                    return movimentosValidos;
                }
            }
            j--;
        }
        return movimentosValidos;
    }
}
