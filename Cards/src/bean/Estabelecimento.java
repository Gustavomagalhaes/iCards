package bean;

/**
 *
 * @author gustavopereira
 */
public class Estabelecimento {
    private String nome;
    private String endereco;
    private String telefone;
    private String CNPJ;
    
    public Estabelecimento (String CNPJ, String nome, String telefone) {
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public Estabelecimento(String nome, String endereco, String telefone, String CNPJ) {
        this.nome = nome;
        this. endereco = endereco;
        this.telefone = telefone;
        this.CNPJ = CNPJ;
    }
    
    public Estabelecimento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    
}
