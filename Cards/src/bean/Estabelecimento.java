package bean;

/**
 *
 * @author gustavopereira
 */
public class Estabelecimento {
    private String nome;
    private String endereco;
    private String CNPJ;
    
    public Estabelecimento (String CNPJ, String nome) {
        this.CNPJ = CNPJ;
        this.nome = nome;
    }
    
    public Estabelecimento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    
}
