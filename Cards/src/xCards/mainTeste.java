package xCards;

import negocio.GerenciarDB;

/**
 *
 * @author gustavopereira
 */
public class mainTeste {
   
    public static void main(String[] args) throws Exception{
        GerenciarDB banco = new GerenciarDB();
        banco.addUsuario(666666666,"Capeta","hell@bol.com","Inferno Av.","66326694","06/06/06","Hell",1,1234,"adm1234senha");
    }
}
