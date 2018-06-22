package br.fatecfranca.model;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class LoginDAOImpl implements LoginDAO{
    private PreparedStatement canal; // canal de comunicação
    private Connection conexao; // conexão com o banco
    public Connection conecta(){
            BancoDados bd = new BancoDados();
            return bd.conecta(); // conecta e retorna objeto de conexão 
    }
    @Override
    public int insere(Login login) {
        try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "insert into login (nome, senha) values (?,?)";
                // canal
                canal = conexao.prepareStatement(sql);
                // atribui os valores
                canal.setString(1, login.getNome());
                canal.setString(2, login.getSenha());
                // executa a inserção
                canal.execute();
                return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" LoginDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public int remove(Login login) {
         try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "delete from login where codigo = ?";
                // canal
                canal = conexao.prepareStatement(sql);
                // atribui os valores do aluno
                canal.setInt(1, login.getCodigo());
                // executa a inserção
                canal.execute();
                return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" LoginDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public int atualiza(Login login) {
       try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "update login set nome = ? , senha = ? where codigo = ?";
            // canal
            canal = conexao.prepareStatement(sql);
            // atribui os valores do aluno
            canal.setString(1, login.getNome());
            canal.setString(2, login.getSenha());
            canal.setInt(3, login.getCodigo());
            
            // executa a inserção
            canal.execute();
            return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" LoginDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public List<Login> consulta() {
        // guarda a lista de alunos
        ArrayList<Login> logins = new ArrayList();
        try{
            conexao = conecta(); // conecta
            if (conexao != null){ // conectou
                String sql = "select * from login";
                // canal de comunicação
                canal = conexao.prepareStatement(sql);
                // executa a consulta
                ResultSet rs = canal.executeQuery();
                while (rs.next()){ // cada linha
                    Login login = new Login();
                    login.setCodigo(rs.getInt("codigo"));
                    login.setNome(rs.getString("nome"));
                    login.setSenha(rs.getString("senha"));
                    // adiciona no array
                    logins.add(login);
                } // fecha while
                return logins; // arraylist com login
            }
            else return null; // erro
        }
        catch(Exception e){
            return null; // erro
        }
    }
}
