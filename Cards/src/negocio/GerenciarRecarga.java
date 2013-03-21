package negocio;
import bean.Cartao;
import bean.Recarga;

/**
 *
 * @author gustavopereira
 */
public class GerenciarRecarga {
    private Recarga recarga;
    private Cartao cartao;

    public GerenciarRecarga(Recarga recarga, Cartao cartao) {
        this.recarga = recarga;
        this.cartao = cartao;
    }
    
    public void solicitarRecarga() throws Exception{
        GerenciarDB banco = new GerenciarDB();
        banco.updateSaldoCartaoDB(cartao.getNumero(), cartao.getSaldo(), "MAIS", recarga.getValor());
    }
    
    public void salvarRecarga(){
        //Desenvolver parte de banco
    }
    
}
