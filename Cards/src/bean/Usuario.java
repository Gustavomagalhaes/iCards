package bean;

/**
 *
 * @author hanna
 */
public class Usuario {
    private String nome;
    private String cpf;
    private String tipoUsuario;
    private String email;
    private String endereco;
    private String datanascimento;
    private String nacionalidade;
    private Cartao cartao;
    private String CPFtitular;
    private String telefone;

    public Usuario(String nome, String cpf, String tipoUsuario, String email, String endereco, String datanascimento, String nacionalidade, String CPFtitular, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.endereco = endereco;
        this.datanascimento = datanascimento;
        this.nacionalidade = nacionalidade;
        this.CPFtitular = CPFtitular;
        this.telefone = telefone;
    }
    
    public Usuario() {
        //
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCPFtitular() {
        return this.CPFtitular;
    }

    public void setCPFtitular(String CPFtitular) {
        this.CPFtitular = CPFtitular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setName(String nome){
        this.nome = nome;
    } 
    
    public String getNome(){
         return nome;
    }
 
    public void setCpf(String cpf){
         this.cpf = cpf;
    }  
    
    public String getCpf(){
         return cpf;
    }
 
    public void setTipoUsuario(String tipoUsuario){
         this.tipoUsuario = tipoUsuario;
    }   
    
    public String getTipoUsuario(){
         return tipoUsuario;
    }
    public void setEmail(String email){
         this.email = email;
    }   
    public String getEmail(){
         return email;
    }
 
    public void setEndereco(String endereco){
         this.endereco = endereco;
    } 
    
    public String getEndereco(){
         return endereco;
    }
    
    public void setNacionalidade(String nacionalidade){
         this.nacionalidade = nacionalidade;
    }  
    
    public String getNacionalidade(){
         return nacionalidade;
    }
 
    public void setCartao(Cartao cartao){
         this.cartao = cartao;
    }  
    
    public Cartao getCartao(){
         return cartao;
    }
}