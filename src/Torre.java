import java.util.ArrayList;

public class Torre extends Peca {
    public Torre (Casa casa, int tipo) {
        super(casa, tipo);
    }
     public void mover (Casa destino) {
        ArrayList<Casa> movimentosValidos = movimentosValidos();
        movimentosValidos.forEach(m -> {
            if (destino.equals(m)) {
                casa.removerPeca();
                destino.colocarPeca(this);
                casa = destino;
            }
        });
    }
    public ArrayList<Casa> movimentosValidos () {
        ArrayList<Casa> movimentosValidos = new ArrayList<Casa>();
        int incY = casa.getY();
        while (true) {
            incY++;
            if (casa.getY() == 7 || incY == 7) {
                break;
            }
            Casa proximaCasa = new Casa(casa.getX(), incY);
            if (!(proximaCasa.possuiPeca())) {
                movimentosValidos.add(proximaCasa);
            }
        }
        return movimentosValidos;
    }
}
    
