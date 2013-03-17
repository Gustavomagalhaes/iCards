package xCards;

import negocio.GerenciarDB;

/**
 *
 * @author gustavopereira
 */
public class mainTeste {
   
    public static void main(String[] args) throws Exception{
        GerenciarDB banco = new GerenciarDB();
        //banco.addUsuario("12345678901","Gustavo Pereira","gp@panda.com","Av. Brasil","3632-6694","01/02/1992","British","TITULAR",null);
        //banco.addUsuario("12341234123","Rafaella Leandra","rl@panda.com","Jaboatão","3636-9994","24/07/1992","Brasileira","TITULAR",null);
        //banco.addUsuario("33333444443","Hanna Montana","hm@panda.com","Hollywood","3632-6694","27/02/1990","American","DEPENDENTE","12341234123");
        //banco.addUsuario("15151515151","Robson Ugo","ru@panda.com","London Bridge","9999-6694","15/04/1993","British","TITULAR",null);
        //banco.addUsuario("13131313131","Daniel Cândido","dc@panda.com","Rio Doce","9999-6694","30/09/1993","British","DEPENDENTE","15151515151");
        //banco.delUsuario("12345678901"); 
        //Teste de Usuário finalizado
        
        //banco.addEstabelecimento("15131513", "Disneyland", "34543433");
        //banco.addEstabelecimento("44446666", "McDonalds", "34543445");
        //banco.addEstabelecimento("22332233", "Burguer King", "34543465");
        //banco.addEstabelecimento("11221122", "Livraria Saraiva", "34546669");
        //banco.addEstabelecimento("11111111", "mama", "34546669");
        //banco.delEstabelecimento("11111111"); 
        
        
        //OPERACAO DE ADD/DEL DE CARTAO. 
        //banco.addCartao("10000001","12341234123");
        //banco.delCartao("11111111");
        
        
        //OPERACAO DE ADD DE DINHEIRO NO CARTAO. 
        //banco.addExtrato("Robson Ugo", "120", "10/03/2013", null, "11111111");
        //banco.updateSaldoCartaoDB(11111111,banco.getSaldoCartaoDB(11111111), "MAIS", 120);
        //banco.delExtrato(4); //ADMIN
        
        
        //OPERACAO DE RETIRADA DE DINHEIRO NO CARTAO. 
        //banco.addExtrato(banco.getEstabelecimentoDB("15131513"), "20", "11/03/2013", "15131513", "11111111");
        //banco.updateSaldoCartaoDB("11111111", banco.getSaldoCartaoDB("11111111"), "MENOS", 20);
        
        
        //UPDATE DO LUCRO DO ESTABELECIMENTO. 
        //banco.updateVendaTotalEstabelecimentoDB("15131513", banco.getVendaTotalEstabelecimentoDB("15131513"), 20);
        //System.out.println(banco.getVendaTotalEstabelecimentoDB("15131513"));
        //banco.delExtrato(3); //ADMIN
        
        
        //VERIFICAR SENHAS DO CARTAO
        //System.out.println(banco.checkSenhaCartaoDB("11111111", "123456", 1)); 
        //banco.updateSenhaCartaoDB("11111111","1111",0); //muda
        //System.out.println(banco.checkSenhaCartaoDB("11111111", "1234", 0)); 
        //System.out.println(banco.checkSenhaCartaoDB("11111111", "123456", 1));
        
        
        //VERIFICAR SENHA ESTABELECIMENTO
        //System.out.println(banco.checkSenhaEstabelecimentoDB("15131513", "123456")); //true
        //banco.updateSenhaEstabelecimentoDB("15131513","1234");
        
        
        //VERIFICAR SALDO
        //System.out.println(banco.getSaldoCartaoDB("11111111"));
        
        //VERIFICAR BLOQUEIO DO CARTAO
        //banco.bloquearCartaoDB("11111111","BLOQUEAR");
        //banco.bloquearCartaoDB("11111111", "DESBLOQUEAR");
        //System.out.println(banco.checkStatusCartaoBloqueadoDB("11111111"));
        
    
    }
}
