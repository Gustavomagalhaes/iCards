package negocio;
import bean.Cartao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gustavopereira
 */
public class GerenciarCartao {
    private Cartao cartao;

    public GerenciarCartao (Cartao cartao) {
        this.cartao = cartao;
    }
    
        public GerenciarCartao () {
    }
    
    public void alterarSenha() {
        //
    }
        
    public double visualizarSaldo(){
        return this.cartao.getSaldo();
    }
    
    public void imprimirExtrato(){
        //Desenvolver
    }
     
    public void desbloquearCartao() throws Exception{
        GerenciarDB banco = new GerenciarDB();
        banco.bloquearCartaoDB(cartao.getNumero(), "DESBLOQUEAR");
    }
    
    public double verificarSaldo() throws Exception{
        GerenciarDB banco = new GerenciarDB();
        double saldoCartao = banco.getSaldoCartaoDB(cartao.getNumero());
        return saldoCartao;
    }
    
    public void bloquearCartao() throws Exception{
        GerenciarDB banco = new GerenciarDB();
        banco.bloquearCartaoDB(cartao.getNumero(), "BLOQUEAR");
    }
    
}
