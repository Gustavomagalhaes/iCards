package negocio;
import bean.Debito;

/**
 *
 * @author gustavopereira
 */
public class GerenciarDebito {
    private Debito debito;

    public GerenciarDebito (Debito debito) {
        this.debito = debito;
    }
    
    public void debitar() throws Exception {
        GerenciarDB banco = new GerenciarDB();
        banco.updateSaldoCartaoDB(debito.getCartao().getNumero(), debito.getCartao().getSaldo(), "MENOS", debito.getValor());
    }
    
    public void salvarExtrato(){
        //Desenvolver parte do banco
    } 
}
