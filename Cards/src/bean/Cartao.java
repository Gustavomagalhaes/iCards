package bean;

/**
 *
 * @author gustavopereira
 */
public class Cartao {
    private String numero;
    private double saldo;
    
    public Cartao(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
