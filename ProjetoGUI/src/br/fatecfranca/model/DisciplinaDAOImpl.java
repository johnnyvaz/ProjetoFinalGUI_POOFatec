package br.fatecfranca.model;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DisciplinaDAOImpl implements DisciplinaDAO{
    private PreparedStatement canal; // canal de comunicação
    private Connection conexao; // conexão com o banco
    public Connection conecta(){
            BancoDados bd = new BancoDados();
            return bd.conecta(); // conecta e retorna objeto de conexão 
    }
    @Override
    public int insere(Disciplina disciplina) {
        try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "insert into disciplina (nome, cargaHoraria, professor) values (?,?,?)";
                // canal
                canal = conexao.prepareStatement(sql);
                // atribui os valores do disciplina
                canal.setString(1, disciplina.getNome());
                canal.setString(2, disciplina.getCargaHoraria());
                canal.setString(3, disciplina.getProfessor());
                // executa a inserção
                canal.execute();
                return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" DisciplinaDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public int remove(Disciplina disciplina) {
         try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "delete from disciplina where codigo = ?";
                // canal
                canal = conexao.prepareStatement(sql);
                // atribui os valores do disciplina
                canal.setInt(1, disciplina.getCodigo());
                // executa a inserção
                canal.execute();
                return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" DisciplinaDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public int atualiza(Disciplina disciplina) {
       try{
            conexao = conecta();
            if (conexao != null){ // conectou
String sql = "update disciplina set nome = ?, cargaHoraria = ?, professor = ?";
            // canal
            canal = conexao.prepareStatement(sql);
            // atribui os valores do disciplina
            canal.setString(1, disciplina.getNome());
            canal.setString(2, disciplina.getCargaHoraria());
            canal.setString(3, disciplina.getProfessor());
            canal.setInt(4, disciplina.getCodigo());
            
            
            // executa a inserção
            canal.execute();
            return 1;
            }
            else return 0;
        }
        catch(Exception e){
            System.out.println(" DisciplinaDAOImpl" + e.getMessage());
            return -1;
        }
    }
    @Override
    public List<Disciplina> consulta() {
        // guarda a lista de disciplinas
        ArrayList<Disciplina> disciplinas = new ArrayList();
        try{
            conexao = conecta(); // conecta
            if (conexao != null){ // conectou
                String sql = "select * from disciplina";
                // canal de comunicação
                canal = conexao.prepareStatement(sql);
                // executa a consulta
                ResultSet rs = canal.executeQuery();
                while (rs.next()){ // cada linha
                    Disciplina disciplina = new Disciplina();
                    disciplina.setNome(rs.getString("nome"));
                    disciplina.setCodigo(rs.getInt("codigo"));
                    disciplina.setCargaHoraria(rs.getString("cargaHoraria"));
                    disciplina.setProfessor(rs.getString("professor"));
                    // adiciona no array
                    disciplinas.add(disciplina);
                } // fecha while
                return disciplinas; // arraylist com disciplinas
            }
            else return null; // erro
        }
        catch(Exception e){
            return null; // erro
        }
    }
}
