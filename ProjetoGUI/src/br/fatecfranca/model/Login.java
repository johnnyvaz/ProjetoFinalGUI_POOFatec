
package br.fatecfranca.model;
public class Login {
    private int codigo;
    private String nome,senha;
    public Login() {
        this.codigo = 0;
        this.nome = "";
        this.senha = "";
    }
    public Login(int codigo, String nome, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
