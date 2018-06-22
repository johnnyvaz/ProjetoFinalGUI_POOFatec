

package br.fatecfranca.model;
import java.util.List;
public interface AlunoDAO {
    public int insere(Aluno aluno);
    public int remove(Aluno aluno);
    public int atualiza(Aluno aluno);
    public List<Aluno> consulta();
}
