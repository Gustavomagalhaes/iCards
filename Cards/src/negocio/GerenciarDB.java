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
    
    public void addEstabelecimento(double CNPJ, String nome, String telefone)throws Exception{
        conectaDB();
        String query;
        double vendatotal = 0;
        String senhaCNPJ = "Est1234";
        query = "INSERT INTO estabelecimento (CNPJ, nome, telefone, vendatotal, senhaCNPJ) VALUES ('"+CNPJ+"','"+nome+"','"+telefone+"','"+vendatotal+"','"+senhaCNPJ+"')";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void addCartao(double IDcartao, String CPF)throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO cartao (IDcartao, CPF, bloqueado) VALUES ('"+IDcartao+"','"+CPF+"',"+true+")";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void addExtratoDeposito(double IDcartao, String pessoa, double valor, String data)throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO extrato (IDcartao, pessoa, valor, data) VALUES ('"+IDcartao+"','"+pessoa+"','"+valor+"','"+data+"')";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void addExtratoDebito(double CNPJ,double IDcartao, double valor, String data)throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO extrato (CNPJ ,IDcartao, valor, data) VALUES ('"+CNPJ+"','"+IDcartao+"','"+valor+"','"+data+"')";
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
    
    public void delEstabelecimento(double CNPJ)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM estabelecimento WHERE CNPJ = '"+CNPJ+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void delCartao(double IDcartao)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM cartao WHERE IDcartao = '"+IDcartao+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    public void delExtrato(int IDextrato)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM extrato WHERE IDextrato = '"+IDextrato+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    public boolean checkSenhaCartaoDB(double IDcartao, String senha, int tipo)throws Exception{
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
    
    public void updateSenhaCartaoDB(double IDcartao, String senha, int tipo)throws Exception{
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
    
    public double getSaldoCartaoDB(double IDcartao)throws Exception{
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
    
public void updateSaldoCartaoDB(double IDcartao, double saldoatual, String operation, double valor)throws Exception{
        conectaDB();
        String query;
        double novosaldo;
        GerenciarDB interno = new GerenciarDB();
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
} 

