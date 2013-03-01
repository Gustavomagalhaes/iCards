package bean;

/**
 *
 * @author gustavopereira
 */
public class Cartao {
    private long numero;
    private int numcontrole;
    private float saldo;
    
    public Cartao() {
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getNumcontrole() {
        return numcontrole;
    }

    public void setNumcontrole(int numcontrole) {
        this.numcontrole = numcontrole;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
