package negocio;
import bean.Cartao;
import bean.Usuario;

/**
 *
 * @author gustavopereira
 */
public class GerenciarUsuario {
    private Usuario usuario;

    public GerenciarUsuario (Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void alterarSenhaOnlineTitular(Usuario usuario, String senha) throws Exception{        
        GerenciarDB banco = new GerenciarDB();
        banco.updateSenhaCartaoDB(usuario.getCartao().getNumero(), senha, 1);
    }
    
    public void alterarSenhaOnlineDependente(Usuario usuario, String senha) throws Exception{        
        GerenciarDB banco = new GerenciarDB();
        banco.updateSenhaCartaoDB(usuario.getCartao().getNumero(), senha, 2);
    }
    
    public void alterarSenhaCartao(int senha){
        //Desenvolver
    }
    
    public void alterarEmail(String email){
        //Desenvolver
    }
    
    public void alterarEndereco(String rua){
        //Desenvolver
    }
    
    public void alterarTipoUsuario(int tipo){
        //Desenvolver
    }
    
    public void alterarCartao(Cartao cartao){
        this.usuario.setCartao(cartao);
    }
    
    
}
