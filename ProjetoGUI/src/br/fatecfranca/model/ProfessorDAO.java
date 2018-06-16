

package br.fatecfranca.model;
import java.util.List;
public interface ProfessorDAO {
    public int insere(Professor professor);
    public int remove(Professor professor);
    public int atualiza(Professor professor);
    public List<Professor> consulta();
}
