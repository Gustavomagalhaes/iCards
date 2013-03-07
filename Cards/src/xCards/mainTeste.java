package xCards;

import negocio.GerenciarDB;

/**
 *
 * @author gustavopereira
 */
public class mainTeste {
   
    public static void main(String[] args) throws Exception{
        GerenciarDB banco = new GerenciarDB();
        banco.addUsuario("12345SON","Capeta","hell@bol.com","Inferno Av.","66326694","06/06/2006","Hell","ADM","12345PAI","adm123");
    }
}
