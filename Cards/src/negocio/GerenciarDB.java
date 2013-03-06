package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author gustavopereira
 */
public class GerenciarDB {
    static Connection conexao;
   
    public static void conectaDB(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:icards.serveftp.com";
        String login = "panda";
        String password = "bazinga";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,login,password);
            System.out.println("Conexao bem sucedida");
        } catch (Exception e){
            System.out.println("Conexao falhou");
        }
    }
    
    public static void desconectaDB()throws Exception{
        conexao.close();
    }
    
    public static void executaDB(String query)throws Exception{
        Statement exe = conexao.createStatement();
        exe.executeUpdate(query);
    }
    
    public void addUsuario(int cpf,String nome,String email,String endereco,String telefone,String datanascimento,String nacionalidade,int tipousuario,int cpftitular,String senhaadm) throws Exception{
        conectaDB();
        System.out.print("OK ate aqui");
        String query;
        query = "insert into USUARIO (cpf,nome,email,endereco,telefone,datanascimento,nacionalidade,tipousuario,cpftitular,senhaadm) "
                + "values (cpf,nome,email,endereco,telefone,datanascimento,nacionalidade,tipousuario,cpftitular,senhaadm)";
        executaDB(query);
        desconectaDB();
    }
}
