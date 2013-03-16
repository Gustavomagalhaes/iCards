package bean;

/**
 *
 * @author gustavopereira
 */
public class Recarga {
    private double valor;
    private String pessoa;
    private String data;

    public Recarga() {    
    }

    public double getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
