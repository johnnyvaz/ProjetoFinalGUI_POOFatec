

package br.fatecfranca.model;
import java.util.List;
public interface DisciplinaDAO {
    public int insere(Disciplina disciplina);
    public int remove(Disciplina disciplina);
    public int atualiza(Disciplina disciplina);
    public List<Disciplina> consulta();
}
