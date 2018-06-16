package br.fatecfranca.model;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class ProfessorDAOImpl implements ProfessorDAO{
    private PreparedStatement canal; // canal de comunicação
    private Connection conexao; // conexão com o banco
    public Connection conecta(){
            BancoDados bd = new BancoDados();
            return bd.conecta(); // conecta e retorna objeto de conexão 
    }
    @Override
    public int insere(Professor professor) {
        try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "insert into professor (cidade, cpf, documentos, endereco, estado, "
        + "nome, rg, sexo) values (?,?,?,?,?,?,?,?)";
                // canal
                canal = conexao.prepareStatement(sql);
                // atribui os valores do professor
                canal.setString(1, professor.getCidade());
                canal.setString(2, professor.getCpf());
                canal.setString(3, professor.getDocumentos());
                canal.setString(4, professor.getEndereco());
                canal.setString(5, professor.getEstado());
                canal.setString(6, professor.getNome());
                canal.setString(7, professor.getRg());
                canal.setString(8, professor.getSexo());
                // executa a inserção
                canal.execute();
                return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" ProfessorDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public int remove(Professor professor) {
         try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "delete from professor where codigo = ?";
                // canal
                canal = conexao.prepareStatement(sql);
                // atribui os valores do professor
                canal.setInt(1, professor.getCodigo());
                // executa a inserção
                canal.execute();
                return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" ProfessorDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public int atualiza(Professor professor) {
       try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "update professor set cidade = ?, cpf = ?, documentos = ?, "
        + "endereco = ?, estado = ?, nome = ? , rg = ?, sexo = ? where "
        + "codigo = ?";
            // canal
            canal = conexao.prepareStatement(sql);
            // atribui os valores do professor
            canal.setString(1, professor.getCidade());
            canal.setString(2, professor.getCpf());
            canal.setString(3, professor.getDocumentos());
            canal.setString(4, professor.getEndereco());
            canal.setString(5, professor.getEstado());
            canal.setString(6, professor.getNome());
            canal.setString(7, professor.getRg());
            canal.setString(8, professor.getSexo());
            canal.setInt(9, professor.getCodigo());
            
            // executa a inserção
            canal.execute();
            return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" ProfessorDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public List<Professor> consulta() {
        // guarda a lista de professors
        ArrayList<Professor> professores = new ArrayList();
        try{
            conexao = conecta(); // conecta
            if (conexao != null){ // conectou
                String sql = "select * from professor";
                // canal de comunicação
                canal = conexao.prepareStatement(sql);
                // executa a consulta
                ResultSet rs = canal.executeQuery();
                while (rs.next()){ // cada linha
                    Professor professor = new Professor();
                    professor.setCidade(rs.getString("cidade"));
                    professor.setCodigo(rs.getInt("codigo"));
                    professor.setCpf(rs.getString("cpf"));
                    professor.setDocumentos(rs.getString("documentos"));
                    professor.setEndereco(rs.getString("endereco"));
                    professor.setEstado(rs.getString("estado"));
                    professor.setNome(rs.getString("nome"));
                    professor.setRg(rs.getString("rg"));
                    professor.setSexo(rs.getString("sexo"));
                    // adiciona no array
                    professores.add(professor);
                } // fecha while
                return professores; // arraylist com professors
            }
            else return null; // erro
        }
        catch(Exception e){
            return null; // erro
        }
    }
}
