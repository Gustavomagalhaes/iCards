package negocio;
import bean.Cartao;

/**
 *
 * @author gustavopereira
 */
public class GerenciarCartao {
    private Cartao cartao;

    public GerenciarCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    
    public float visualizarSaldo(){
        return this.cartao.getSaldo();
    }
    
    public void imprimirExtrato(){
        //Desenvolver
    }
    
    public void desbloquearCartao(){
        //Desenvolver
    }
    
    public void verificarSaldo(){
        //Desenvolver
    }
    
    public void bloquearCartao(){
        //Desenvolver
    }
    
}
