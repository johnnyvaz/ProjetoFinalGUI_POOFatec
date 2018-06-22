

package br.fatecfranca.model;
import java.util.List;
public interface LoginDAO {
    public int insere(Login login);
    public int remove(Login login);
    public int atualiza(Login login);
    public List<Login> consulta();
}
