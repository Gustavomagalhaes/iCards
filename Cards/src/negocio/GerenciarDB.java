package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author gustavopereira
 */
public class GerenciarDB {
    static Connection conexao;
   
    public static void conectaDB() throws ClassNotFoundException{ //FUNCIONANDO
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://icards.serveftp.com:3306/ICARDS";
        String login = "panda";
        String password = "bazinga";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,login,password);
            System.out.println("Conexao bem sucedida");
        } catch (ClassNotFoundException e) {
            System.out.println("Classe falhou"+e.getMessage());
        } catch (SQLException e){
            System.out.println("Conexao falhou"+e.getMessage());
        }
    }
    
    public static void desconectaDB()throws Exception{
        conexao.close();
    }
    
    public static void executaDB(String query)throws Exception{
        Statement exe = conexao.createStatement();
        exe.executeUpdate(query);
        exe.close();
    }
    
    public void addUsuario(String CPF,String nome,String email,String endereco,String telefone,String datanascimento,String nacionalidade,String tipousuario,String CPFtitular,String senhaADM) throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO usuario (CPF, nome, email,endereco, telefone, datanascimento, nacionalidade, tipousuario, CPFtitular, senhaADM) VALUES ('"+CPF+"','"+nome+"','"+email+"','"+endereco+"','"+telefone+"','"+datanascimento+"','"+nacionalidade+"','"+tipousuario+"','"+CPFtitular+"','"+senhaADM+"')";
        executaDB(query);
        desconectaDB();
    }
    
    public void addEstabelecimento(String CNPJ, String nome, String telefone)throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO estabelecimento (CNPJ, nome, telefone, senhaCNPJ) VALUES ('"+CNPJ+"','"+nome+"','"+telefone+"',"+"'Est1234'"+")";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void addCartao(String IDcartao, String CPF)throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO cartao (IDcartao, CPF, bloqueado) VALUES ('"+IDcartao+"','"+CPF+"',"+"'SIM'"+")";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void addExtrato(String pessoa, double valor, String data, String CNPJ, String IDcartao)throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO extrato (pessoa, valor, data, CNPJ, IDcartao) VALUES ('"+pessoa+"','"+valor+"','"+data+"','"+CNPJ+"','"+IDcartao+"')";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void delUsuario(String CPF)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM usuario WHERE CPF = '"+CPF+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void delEstabelecimento(String CNPJ)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM estabelecimento WHERE CNPJ = '"+CNPJ+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void delCartao(String IDcartao)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM cartao WHERE IDcartao = '"+IDcartao+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void delExtrato(String IDextrato)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM extrato WHERE IDextrato = '"+IDextrato+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    public boolean checkSenhaCartaoDB(String IDcartao, String senha, int tipo)throws Exception{
        conectaDB();
        String query;
        query = "SELECT * FROM cartao WHERE IDcartao = '"+IDcartao+"'";
        PreparedStatement exe = conexao.prepareStatement(query);

        ResultSet retorno = exe.executeQuery();
        String passcartao = null;
        String passtitular = null;
        String passdependente = null;
        while (retorno.next()) { 
           passcartao = retorno.getString(2);
           passtitular = retorno.getString(4);
           passdependente = retorno.getString(5);
        }
        desconectaDB();
        boolean resp;
        if (tipo == 0){
            resp = senha.equals(passcartao);
        } else if(tipo == 1){
            resp = senha.equals(passtitular);
        } else if (tipo == 2){
            resp = senha.equals(passdependente);
        } else {
            resp = false;
        }
        return resp;
    }
    
    public void updateSenhaCartaoDB(String IDcartao, String senha, int tipo)throws Exception{
        conectaDB();
        String query;
        if (tipo == 0){
            query = "UPDATE cartao SET senhacartao = '"+senha+"' WHERE IDcartao = '"+IDcartao+"'";
            executaDB(query);
        } else if(tipo == 1){
            query = "UPDATE cartao SET senhaonlinetitular = '"+senha+"' WHERE IDcartao = '"+IDcartao+"'";
            executaDB(query);
        } else if (tipo == 2){
            query = "UPDATE cartao SET senhaonlinedependente = '"+senha+"' WHERE IDcartao = '"+IDcartao+"'";
            executaDB(query);
        }
        desconectaDB();
    }
    
    public double getSaldoCartaoDB(String IDcartao)throws Exception{
        conectaDB();
        String query;
        query = "SELECT * FROM cartao WHERE IDcartao = '"+IDcartao+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String saldodocartao;
        double saldo = 0;
        while (retorno.next()) { 
           saldodocartao = retorno.getString(3);
           saldo = Double.parseDouble(saldodocartao);
        }
        desconectaDB();
        return saldo; 
    }
    
        public String getEstabelecimentoDB(String CNPJ)throws Exception{
        conectaDB();
        String query;
        query = "SELECT * FROM estabelecimento WHERE CNPJ = '"+CNPJ+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String nome = null;
        while (retorno.next()) { 
           nome = retorno.getString(2);
        }
        desconectaDB();
        return nome; 
    }
    
    public void updateSaldoCartaoDB(String IDcartao, double saldoatual, String operation, double valor)throws Exception{
        conectaDB();
        String query;
        double novosaldo;
        if (operation.equalsIgnoreCase("MAIS")) {
            novosaldo = saldoatual+valor;
        } else if (operation.equalsIgnoreCase("MENOS")){
            novosaldo = saldoatual-valor;
        } else {
            novosaldo = saldoatual;
        }
        query = "UPDATE cartao SET saldo = '"+novosaldo+"' WHERE IDcartao = '"+IDcartao+"'";
        executaDB(query);
        desconectaDB();
    }
    
    public double getVendaTotalEstabelecimentoDB(String CNPJ)throws Exception{
        conectaDB();
        String query;
        query = "SELECT * FROM estabelecimento WHERE CNPJ = '"+CNPJ+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String saldodocartao;
        double valor = 0;
        while (retorno.next()) { 
           saldodocartao = retorno.getString(4);
           valor = Double.parseDouble(saldodocartao);
        }
        desconectaDB();
        return valor; 
    }
    
    public void updateVendaTotalEstabelecimentoDB(String CNPJ, double saldoatual, double valor)throws Exception{
        conectaDB();
        String query;
        double novosaldo = saldoatual+valor;
        query = "UPDATE estabelecimento SET vendatotal = '"+novosaldo+"' WHERE CNPJ = '"+CNPJ+"'";
        executaDB(query);
        desconectaDB();
    }

    public void bloquearCartaoDB(String IDcartao, String operation)throws Exception{
        conectaDB();
        String query;
        String block = "";
        if (operation.equalsIgnoreCase("BLOQUEAR")) {
            block = "SIM";
        } else if (operation.equalsIgnoreCase("DESBLOQUEAR")){
            block = "NÃO";
        }
        query = "UPDATE cartao SET bloqueado = '"+block+"' WHERE IDcartao = '"+IDcartao+"'";
        executaDB(query);
        desconectaDB();
    }
    
    public boolean checkStatusCartaoBloqueadoDB(String IDcartao)throws Exception{
        conectaDB();
        String query;
        query = "SELECT * FROM cartao WHERE IDcartao = '"+IDcartao+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String nome = null;
        while (retorno.next()) { 
           nome = retorno.getString(6);
        }
        desconectaDB();
        boolean resp;
        if (nome.equalsIgnoreCase("NÃO")) {
            resp = false;
        } else if (nome.equalsIgnoreCase("SIM")){
            resp = true;
        } else {
            resp = true;
        }
        //return nome; //Se quiser retornar SIM/NÃO como e
        return resp; 
    }
    
    public void updateSenhaEstabelecimentoDB(String CNPJ, String senha)throws Exception{
        conectaDB();
        String query;
        query = "UPDATE estabelecimento SET senhaCNPJ = '"+senha+"' WHERE CNPJ = '"+CNPJ+"'";
        executaDB(query);
        desconectaDB();
    }
    
    public boolean checkSenhaEstabelecimentoDB(String CNPJ, String senha)throws Exception{
        conectaDB();
        String query;
        query = "SELECT * FROM estabelecimento WHERE CNPJ = '"+CNPJ+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String password = null;
        while (retorno.next()) { 
           password = retorno.getString(5);
        }
        desconectaDB();
        boolean resp;
        if (password.equals(senha)){
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }
} 

