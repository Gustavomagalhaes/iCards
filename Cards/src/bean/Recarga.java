package bean;

import negocio.GerenciarDB;

/**
 *
 * @author iCards
 */
public class Recarga {
    private double valor;
    private String pessoa;
    private String data;

    public Recarga(double valor, String pessoa) {
        this.valor = valor;
        this.pessoa = pessoa;
        GerenciarDB banco = new GerenciarDB();
        this.data = banco.getData();
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
