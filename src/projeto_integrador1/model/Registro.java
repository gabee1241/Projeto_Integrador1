package projeto_integrador1.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   
   @Column(nullable = false)
   private String nome;
   
   @Column(name = "identificacao", nullable = false)
   private String identificacao;
   
   @Column(name = "idade", nullable = false)
   private int idade;
   
   @Column(nullable = false)
   private String curso_departamento;
   
   // Getters and setters
   public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getIdentificacao() {
    return identificacao;
}

public void setIdentificacao(String identificacao) {
    this.identificacao = identificacao;
}

public int getIdade() {
    return idade;
}

public void setIdade(int idade) {
    this.idade = idade;
}

public String getCurso_departamento() {
    return curso_departamento;
}

public void setCurso_departamento(String curso_departamento) {
    this.curso_departamento = curso_departamento;
}
}

   
