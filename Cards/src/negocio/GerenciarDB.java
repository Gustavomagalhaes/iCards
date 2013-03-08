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
    
    public static void executaDB(String query)throws Exception{
        Statement exe = conexao.createStatement();
        exe.executeUpdate(query);
        
    }
    
    public void addUsuario(String CPF,String nome,String email,String endereco,String telefone,String datanascimento,String nacionalidade,String tipousuario,String CPFtitular,String senhaADM) throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO usuario VALUES ('1234','1234','1234','1234','1234','1234','1234','1234','1234','1234')";
        executaDB(query);
        //conexao.close();
    }
}
