package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class escud extends artefacte {
    private Random randomizer;

    public escud() {
        randomizer = new Random();
        super.setValorArtefacte(randomizer.nextDouble(0.9, 1.6));
    }

    @Override
    public void utilitzarArtefacte(supervivent s) {
        System.out.println("Utilitzant arma de acer");
        s.setDefensa(((int) (super.getValorArtefacte() * s.getDefensa())));
    }
}
