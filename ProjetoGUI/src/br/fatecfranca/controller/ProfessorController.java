
package br.fatecfranca.controller;
import br.fatecfranca.model.Professor;
import br.fatecfranca.model.ProfessorDAOImpl;
import java.util.List;
public class ProfessorController {
    
    public int insere(Professor professor){
        // controller acessando model
        ProfessorDAOImpl professorDAOImpl = new ProfessorDAOImpl();
        // model retorna dados para controller
        return professorDAOImpl.insere(professor);
    }
    
    public List<Professor> consulta(){
        // controller acessando model
        ProfessorDAOImpl professorDAOImpl = new ProfessorDAOImpl();
        // model retorna dados para controller
        return professorDAOImpl.consulta();
    }
    
     public int remove(Professor professor){
        // controller acessando model
        ProfessorDAOImpl professorDAOImpl = new ProfessorDAOImpl();
        // model retorna dados para controller
        return professorDAOImpl.remove(professor);
    }
    
    public int atualiza(Professor professor){
        // controller acessando model
        ProfessorDAOImpl professorDAOImpl = new ProfessorDAOImpl();
        // model retorna dados para controller
        return professorDAOImpl.atualiza(professor);
    }
     
}
