package bean;

/**
 *
 * @author gustavopereira
 */
public class Debito {
    private Cartao cartao;
    private Estabelecimento local;
    private double valor;
    private String data;
    
    public Debito() {
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Estabelecimento getLocal() {
        return local;
    }

    public void setLocal(Estabelecimento local) {
        this.local = local;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
