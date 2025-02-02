import java.util.ArrayList;

public class Bispo extends Peca {

    private Tabuleiro tabuleiro;
    
    public Bispo (Casa casa, int tipo, Tabuleiro tabuleiro) {
        super(casa, tipo);
        this.tabuleiro = tabuleiro;
    }

    
}
