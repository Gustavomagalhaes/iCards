package negocio;

import bean.Cartao;
import bean.Estabelecimento;
import bean.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author gustavopereira
 */
public class GerenciarDB {
    static Connection conexao;
   
    /**
     * Faz a conexão com o banco de dados
     */
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
    
    /**
     * desfaz a conexão com o banco de dados
     */
    public static void desconectaDB()throws Exception{
        conexao.close();
    }
    
    /**
     * executa um comando sql para acesso ao banco
     */
    public static void executaDB(String query)throws Exception{
        Statement exe = conexao.createStatement();
        exe.executeUpdate(query);
        exe.close();
    }
    
    /**
     * @param Usuario para adição na tabela usuario do banco de dados
     */
    public void addUsuario(Usuario user) throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO usuario (CPF, nome, email,endereco, telefone, datanascimento, nacionalidade, tipousuario, CPFtitular) VALUES ('"+user.getCpf()+"','"+user.getNome()+"','"+user.getEmail()+"','"+user.getEndereco()+"','"+user.getTelefone()+"','"+user.getDatanascimento()+"','"+user.getNacionalidade()+"','"+user.getTipoUsuario()+"','"+user.getCPFtitular()+"')";
        executaDB(query);
        desconectaDB();
    }
    
    /**
     * @param Estabelecimento para adição na tabela estabelecimento do banco de dados
     */
    public void addEstabelecimento(Estabelecimento shop)throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO estabelecimento (CNPJ, nome) VALUES ('"+shop.getCNPJ()+"','"+shop.getNome()+")";
        executaDB(query);
        desconectaDB(); 
    }
    
    /**
     * @param Cartao, Usuario para adição na tabela cartão do banco de dados
     */
    public void addCartao(Cartao card)throws Exception{
        conectaDB();
        String query;
        query = "INSERT INTO cartao (IDcartao, CPF, bloqueado) VALUES ('"+card.getNumero()+"','"+card.getCPFUsuario()+"',"+"'SIM'"+")";
        executaDB(query);
        desconectaDB(); 
    }
    
    /**
     * @param para adição na tabela extrato do banco de dados
     */
    public void addExtrato(String pessoa, String valor, String data, String CNPJ, String IDcartao)throws Exception{
        conectaDB();
        String query;
        if (CNPJ==null){
            valor = "+ R$ "+valor+",00";
        } else {
            valor = "- R$ "+valor+",00";
        }
        query = "INSERT INTO extrato (pessoa, valor, data, CNPJ, IDcartao) VALUES ('"+pessoa+"','"+valor+"','"+data+"','"+CNPJ+"','"+IDcartao+"')";
        executaDB(query);
        desconectaDB(); 
    }
    
    /**
     * @param CPF para deleção na tabela usuario do banco de dados
     */
    public void delUsuario(String CPF)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM usuario WHERE CPF = '"+CPF+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    /**
     * @param CNPJ para deleção na tabela estabelecimento do banco de dados
     */
    public void delEstabelecimento(String CNPJ)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM estabelecimento WHERE CNPJ = '"+CNPJ+"'";
        executaDB(query);
        desconectaDB(); 
    }
    /**
     * @param IDcartao para deleção na tabela cartao do banco de dados
     */
    public void delCartao(String IDcartao)throws Exception{
        conectaDB();
        String query;
        query = "DELETE FROM cartao WHERE IDcartao = '"+IDcartao+"'";
        executaDB(query);
        desconectaDB(); 
    }
    
    /**
     * @param CPF,senha,tipo para checagem na tabela cartao do banco de dados
     * @return true or false
     */
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
    
    /**
     * @param CPF,senha,tipo para checagem na tabela cartao do banco de dados
     */
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
    
    /**
     * @param IDcartao para pegar saldo do cartao no banco de dados
     * @return double saldo
     */
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
    
    /**
     * @param CNPJ para pegar nome do estabelecimento no banco de dados
     */
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
    
    /**
     * @param IDcartao,saldoatual, operação, valor para fazer update de saldo do cartao no banco de dados
     */
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
    
    /**
     * @param CNPJ para pegar venda total do estabelecimento no banco de dados
     * @return double vendatotal
     */
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
    
    /**
     * @param CNPJ para pegar fazer update da venda total do estabelecimento no banco de dados
     */
    public void updateVendaTotalEstabelecimentoDB(String CNPJ, double saldoatual, double valor)throws Exception{
        conectaDB();
        String query;
        double novosaldo = saldoatual+valor;
        query = "UPDATE estabelecimento SET vendatotal = '"+novosaldo+"' WHERE CNPJ = '"+CNPJ+"'";
        executaDB(query);
        desconectaDB();
    }

    /**
     * @param IDcartao e operacao para (des)bloquear cartao no banco de dados
     */
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
    
    /**
     * @param IDcartao para checar se o cartao está bloqueado
     * @return true or false
     */
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
        return resp; 
    }
    
    /**
     * @param CNPJ e novasenha para fazer update na tabela estabelecimento no banco de dados
     */
    public void updateSenhaEstabelecimentoDB(String CNPJ, String novasenha)throws Exception{
        conectaDB();
        String query;
        query = "UPDATE estabelecimento SET senhaCNPJ = '"+novasenha+"' WHERE CNPJ = '"+CNPJ+"'";
        executaDB(query);
        desconectaDB();
    }
    
    /**
     * @param CNPJ e senha para checar a senha do estabelecimento no banco de dados
     */
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
    
    /**
     * Pega a data do sistema
     */
    public String getData(){
        Calendar data = Calendar.getInstance();
        SimpleDateFormat now = new SimpleDateFormat("dd/MM/yyyy");
        String today = now.format(data.getTime());
        return today;
    }

    /**
     * @param IDcartao  para checar se existe cartao na tabela cartao no banco de dados
     * @return true or false
     */
    public boolean checkCartaoDB(String IDcartao)throws Exception {
        boolean resp;
        conectaDB();
        String query;
        query = "SELECT * FROM cartao WHERE IDcartao = '"+IDcartao+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String cartao = null;
        while (retorno.next()) { 
           cartao = retorno.getString(1);
        }
        desconectaDB();
        if (cartao==null){
            resp = false;
        } else {
            resp = true;
        }
        return resp;
    }
    
    /**
     * @param IDcartao e gera o extrato do usuário no banco de dados
     * @return Matrix[][]
     */
    public String[][] getExtratoUsuario(String IDcartao)throws Exception {
        conectaDB();
        String query;
        query = "SELECT * FROM extrato WHERE IDcartao = '"+IDcartao+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
     
        ArrayList valores = new ArrayList();
        ArrayList datas = new ArrayList();
        ArrayList pessoas = new ArrayList();

        while (retorno.next()) {
           pessoas.add(retorno.getString(2));
           valores.add(retorno.getString(3));
           datas.add(retorno.getString(4));
        }
        desconectaDB();
        
        String[][] Matrix = new String[3][datas.size()];
        int tamanho = datas.size();
        for (int i = tamanho-1; i>=0; i--){
            Matrix[0][i] = datas.get(i)+"";
            Matrix[1][i] = pessoas.get(i)+"";
            Matrix[2][i] = valores.get(i)+"";
        }
        return Matrix;
    }
    
        /**
     * @param CNPJ e gera o extrato do usuário no banco de dados
     * @return Matrix[][]
     */
    public String[][] getExtratoEst(String CNPJ)throws Exception {
        conectaDB();
        String query;
        query = "SELECT * FROM extrato WHERE CNPJ = '"+CNPJ+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
     
        ArrayList valores = new ArrayList();
        ArrayList datas = new ArrayList();
        ArrayList pessoas = new ArrayList();

        while (retorno.next()) {
           pessoas.add(retorno.getString(2));
           valores.add(retorno.getString(3));
           datas.add(retorno.getString(4));
        }
        desconectaDB();
        
        String[][] Matrix = new String[3][datas.size()];
        int tamanho = datas.size();
        for (int i = tamanho-1; i>=0; i--){
            Matrix[0][i] = datas.get(i)+"";
            Matrix[1][i] = pessoas.get(i)+"";
            Matrix[2][i] = valores.get(i)+"";
        }
        return Matrix;
    }
    
    /**
     * @param CNPJ  para checar se existe estabelecimento na tabela estabelecimento no banco de dados
     * @return true or false
     */
    public boolean checkEstabelecimentoDB(String CNPJ)throws Exception {
        boolean resp;
        conectaDB();
        String query;
        query = "SELECT * FROM estabelecimento WHERE CNPJ = '"+CNPJ+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String Est = null;
        while (retorno.next()) { 
           Est = retorno.getString(1);
        }
        desconectaDB();
        if (Est==null){
            resp = false;
        } else {
            resp = true;
        }
        return resp;
    }
    
    /**
     * @param CPF  para checar se existe Usuario na tabela usuario no banco de dados
     * @return true or false
     */
    public boolean checkUsuarioDB(String CPF)throws Exception {
        boolean resp;
        conectaDB();
        String query;
        query = "SELECT * FROM usuario WHERE CPF = '"+CPF+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String user = null;
        while (retorno.next()) { 
           user = retorno.getString(1);
        }
        desconectaDB();
        if (user==null){
            resp = false;
        } else {
            resp = true;
        }
        return resp;
    }
    
    /**
     * @param IDcartao  para pegar o nome do usuario do cartao no banco de dados
     * @return String
     */
    public String getUsername(String IDcartao)throws Exception{
        conectaDB();
        String query;
        query = "SELECT * FROM cartao WHERE IDcartao = '"+IDcartao+"'";
        PreparedStatement exe = conexao.prepareStatement(query);
        ResultSet retorno = exe.executeQuery();
        String CPF = null;
        while (retorno.next()) { 
           CPF = retorno.getString(7);
        }
        String query2;
        query2 = "SELECT * FROM usuario WHERE CPF = '"+CPF+"'";
        PreparedStatement exe2 = conexao.prepareStatement(query2);
        ResultSet retorno2 = exe2.executeQuery();
        String nome = null;
        while (retorno2.next()) { 
           nome = retorno2.getString(2);
        }
        desconectaDB();
        return nome; 
    } 
    
}
