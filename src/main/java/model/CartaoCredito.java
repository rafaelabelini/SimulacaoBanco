package model;

public class CartaoCredito implements Cartao {
    private Usuario usuario;
    private double limiteCredito;
    private double limiteDisponivel;
    private double taxa = 0.15;

    public CartaoCredito(Usuario usuario, double taxa) {
        this.usuario = usuario;
        this.taxa = taxa ;
        calcularLimite();
    }

    private void calcularLimite(){
        double fator = usuario.getScore() / 1000.0;
        this.limiteCredito = usuario.getSalario() + (usuario.getSalario() * fator);
        this.limiteDisponivel = this.limiteCredito;
    }


    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        this.limiteDisponivel = limiteCredito;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }


    public void consultarLimiteCredito(){
        System.out.println("Limite de credito atual: " + this.limiteCredito);
    }

    @Override
    public void pagar(double valor) {
        if (valor <= 0) {
            return;
        }
        if (valor <= limiteDisponivel) {
            limiteDisponivel -= valor;
        }
    }

    @Override
    public double consultarSaldo() {
        return limiteDisponivel;
    }
}
