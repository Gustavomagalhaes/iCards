/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo;

/**
 *
 * @author hanna
 */
public class Usuario {
    private String nome;
    private String cpf;
    private int tipoUsuario;
    private String email;
    private String senhaOnline;
    private String senhaCatao;
    private String endereco;
    private String dataNascimento;
    private String nacionalidade;
    private String cartao;
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
 
    public void setTipoUsuario(int tipoUsuario){
         this.tipoUsuario = tipoUsuario;
    }   
    public int getTipoUsuario(){
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
         this.dataNascimento = dataNascimento;
    }   
    public String getDataNascimento(){
         return dataNascimento;
 
    }
 
    public void setNacionalidade(String nacionalidade){
         this.nacionalidade = nacionalidade;
    }   
    public String getNacionalidade(){
         return nacionalidade;
 
    }
 
    public void setCartao(String cartao){
         this.cartao = cartao;
    }   
    public String getCartao(){
         return cartao;
 
    }
 
    public void setResponsavel(Usuario responsavel){
         this.responsavel = responsavel;
    }   
    public Usuario getResponsavel(){
         return responsavel;
 
    }
 
}