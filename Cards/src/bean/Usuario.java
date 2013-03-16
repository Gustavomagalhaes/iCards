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
    private String senhaOnline;
    private String senhaCatao;
    private String endereco;
    private String datanascimento;
    private String nacionalidade;
    private Cartao cartao;
    private Usuario responsavel;
    
    public Usuario() {
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
 
    public void setSenha(String senhaOnline){
         this.senhaOnline = senhaOnline;
    }   
    public String getSenha(){
         return senhaOnline;
    }
 
    public void setSenhaCartao(String senhaCartao){
         this.senhaCatao = senhaCartao;
    }   
    
    public String getSenhaCartao(){
         return senhaCatao;
    }
 
    public void setEndereco(String endereco){
         this.endereco = endereco;
    } 
    
    public String getEndereco(){
         return endereco;
    }
 
    public void setDataNascimento(String dataNascimento){
         this.datanascimento = dataNascimento;
    } 
    
    public String getDataNascimento(){
         return datanascimento;
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
 
    public void setResponsavel(Usuario responsavel){
         this.responsavel = responsavel;
    }   
    
    public Usuario getResponsavel(){
         return responsavel;
    }
    
 
}