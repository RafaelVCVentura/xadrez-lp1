import java.util.ArrayList;

public class Torre extends Peca {

    private Tabuleiro tabuleiro;

    public Torre (Casa casa, int tipo, Tabuleiro tabuleiro) {
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

    public ArrayList<Casa> movimentosValidos () {
        ArrayList<Casa> movimentosValidos = new ArrayList<Casa>();
        int x = casa.getX();
        int y = casa.getY();

        //Valida movimentos para a esquerda (linhas diferentes, mesma coluna)
        
        for (int i = x-1; i >= 0; i--) {
            Casa destino = tabuleiro.getCasa(i, y);
            if (!(destino.possuiPeca())) {
                movimentosValidos.add(destino);
            }
            else {
                if (this.getTipo() <= 5 && destino.getPeca().getTipo() >= 6) {
                    movimentosValidos.add(destino);
                    return movimentosValidos;
                }
                else if (this.getTipo() >= 6 && destino.getPeca().getTipo() <= 5) {
                    movimentosValidos.add(destino);
                    return movimentosValidos;
                }
                else if (this.getTipo() <= 5 && destino.getPeca().getTipo() <= 5 || this.getTipo() >= 6 && destino.getPeca().getTipo() >= 6) {
                    return movimentosValidos;
                }
            }
        }

        //Valida movimentos para a direita (linhas diferentes, mesma coluna)
        for (int i = x+1; i <= 7; i++) {
            Casa destino = tabuleiro.getCasa(i, y);
            if (!(destino.possuiPeca())) {
                movimentosValidos.add(destino);
            }
            else {
                if (this.getTipo() <= 5 && destino.getPeca().getTipo() >= 6) {
                    movimentosValidos.add(destino);
                    return movimentosValidos;
                }
                else if (this.getTipo() >= 6 && destino.getPeca().getTipo() <= 5) {
                    movimentosValidos.add(destino);
                    return movimentosValidos;
                }
                else if (this.getTipo() <= 5 && destino.getPeca().getTipo() <= 5 || this.getTipo() >= 6 && destino.getPeca().getTipo() >= 6) {
                    return movimentosValidos;
                }
            }
        }

        //Valida movimentos para baixo (diferentes linhas, mesma coluna)
        for (int i = y-1; i >= 0; i--) {
            Casa destino = tabuleiro.getCasa(x, i);
            if (!(destino.possuiPeca())) {
                movimentosValidos.add(destino);
            }
            else {
                if (this.getTipo() <= 5 && destino.getPeca().getTipo() >= 6) {
                    movimentosValidos.add(destino);
                    return movimentosValidos;
                }
                else if (this.getTipo() >= 6 && destino.getPeca().getTipo() <= 5) {
                    movimentosValidos.add(destino);
                    return movimentosValidos;
                }
                else if (this.getTipo() <= 5 && destino.getPeca().getTipo() <= 5 || this.getTipo() >= 6 && destino.getPeca().getTipo() >= 6) {
                    return movimentosValidos;
                }
            }
        }

        for (int i = y + 1; i <= 7; i++) {
            Casa destino = tabuleiro.getCasa(x, i);
            if (!(destino.possuiPeca())) {
                movimentosValidos.add(destino);
            }
            else {
                if (this.getTipo() <= 5 && destino.getPeca().getTipo() >= 6) {
                    movimentosValidos.add(destino);
                    return movimentosValidos;
                }
                else if (this.getTipo() >= 6 && destino.getPeca().getTipo() <= 5) {
                    movimentosValidos.add(destino);
                    return movimentosValidos;
                }
                else if (this.getTipo() <= 5 && destino.getPeca().getTipo() <= 5 || this.getTipo() >= 6 && destino.getPeca().getTipo() >= 6) {
                    return movimentosValidos;
                }
            }
        }
        
        return movimentosValidos;
    }
}
    
