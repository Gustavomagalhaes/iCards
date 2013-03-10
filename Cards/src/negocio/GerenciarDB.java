package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
