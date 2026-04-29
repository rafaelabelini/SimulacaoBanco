package model;

import java.util.Random;

public class ServicoScoreSimples implements ServicoScore {


    @Override
    public int calcularScore(Usuario usuario) {
        return 300 + new Random().nextInt(701);
    }
}
