
package br.fatecfranca.controller;
import br.fatecfranca.model.Disciplina;
import br.fatecfranca.model.DisciplinaDAOImpl;
import java.util.List;
public class DisciplinaController {
    
    public int insere(Disciplina disciplina){
        // controller acessando model
        DisciplinaDAOImpl disciplinaDAOImpl = new DisciplinaDAOImpl();
        // model retorna dados para controller
        return disciplinaDAOImpl.insere(disciplina);
    }
    
    public List<Disciplina> consulta(){
        // controller acessando model
        DisciplinaDAOImpl disciplinaDAOImpl = new DisciplinaDAOImpl();
        // model retorna dados para controller
        return disciplinaDAOImpl.consulta();
    }
    
     public int remove(Disciplina disciplina){
        // controller acessando model
        DisciplinaDAOImpl disciplinaDAOImpl = new DisciplinaDAOImpl();
        // model retorna dados para controller
        return disciplinaDAOImpl.remove(disciplina);
    }
    
    public int atualiza(Disciplina disciplina){
        // controller acessando model
        DisciplinaDAOImpl disciplinaDAOImpl = new DisciplinaDAOImpl();
        // model retorna dados para controller
        return disciplinaDAOImpl.atualiza(disciplina);
    }
     
}
