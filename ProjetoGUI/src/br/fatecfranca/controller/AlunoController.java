
package br.fatecfranca.controller;
import br.fatecfranca.model.Aluno;
import br.fatecfranca.model.AlunoDAOImpl;
import java.util.List;
public class AlunoController {
    
    public int insere(Aluno aluno){
        // controller acessando model
        AlunoDAOImpl alunoDAOImpl = new AlunoDAOImpl();
        // model retorna dados para controller
        return alunoDAOImpl.insere(aluno);
    }
    
    public List<Aluno> consulta(){
        // controller acessando model
        AlunoDAOImpl alunoDAOImpl = new AlunoDAOImpl();
        // model retorna dados para controller
        return alunoDAOImpl.consulta();
    }
    
     public int remove(Aluno aluno){
        // controller acessando model
        AlunoDAOImpl alunoDAOImpl = new AlunoDAOImpl();
        // model retorna dados para controller
        return alunoDAOImpl.remove(aluno);
    }
    
    public int atualiza(Aluno aluno){
        // controller acessando model
        AlunoDAOImpl alunoDAOImpl = new AlunoDAOImpl();
        // model retorna dados para controller
        return alunoDAOImpl.atualiza(aluno);
    }
     
}
