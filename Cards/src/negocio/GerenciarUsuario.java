package negocio;
import bean.Cartao;
import bean.Usuario;

/**
 *
 * @author gustavopereira
 */
public class GerenciarUsuario {
    private Usuario usuario;

    public GerenciarUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void alterarSenhaOnline(String senha){
        //Desenvolver
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
        //Desenvolver
    }
    
    
}
