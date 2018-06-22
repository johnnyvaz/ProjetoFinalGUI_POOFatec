
package br.fatecfranca.model;
public class Disciplina {
    private int codigo;
    private String nome, cargaHoraria, professor;
    public Disciplina() {
        this.codigo = 0;
        this.nome = "";
        this.cargaHoraria = "";
        this.professor = "";
    }
    public Disciplina(int codigo, String nome, String cargaHoraria, String professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor; 
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

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
    
}
