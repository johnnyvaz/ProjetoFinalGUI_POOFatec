package br.fatecfranca.controller;

import br.fatecfranca.model.Login;
import br.fatecfranca.model.LoginDAOImpl;
import java.util.List;

public class LoginController {
    
    public int insere(Login login){
        // controller acessando model
        LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
        // model retorna dados para controller
        return loginDAOImpl.insere(login);
    }
    
    public List<Login> consulta(){
        // controller acessando model
        LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
        // model retorna dados para controller
        return loginDAOImpl.consulta();
    }
    
     public int remove(Login login){
        // controller acessando model
        LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
        // model retorna dados para controller
        return loginDAOImpl.remove(login);
    }
    
    public int atualiza(Login login){
        // controller acessando model
        LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
        // model retorna dados para controller
        return loginDAOImpl.atualiza(login);
    }
     
}
