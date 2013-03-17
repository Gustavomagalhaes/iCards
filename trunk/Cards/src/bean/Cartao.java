package bean;

/**
 *
 * @author gustavopereira
 */
public class Cartao {
    private String numero;
    private double saldo;
    private String senhaOnlineTitular;
    private String senhaOnlineDependente;
    private String senhaCartao;

    public Cartao(String numero) {
        this.numero = numero;
    }

    public String getSenhaOnlineTitular() {
        return senhaOnlineTitular;
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

    public String getSenhaOnlineDependente() {
        return senhaOnlineDependente;
    }

    public void setSenhaOnlineDependente(String senhaOnlineDependente) {
        this.senhaOnlineDependente = senhaOnlineDependente;
    }

    public String getSenhaCartao() {
        return senhaCartao;
    }

    public void setSenhaCartao(String senhaCartao) {
        this.senhaCartao = senhaCartao;
    }

}
