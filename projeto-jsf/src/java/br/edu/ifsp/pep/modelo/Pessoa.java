package br.edu.ifsp.pep.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "pessoa")
//@DiscriminatorColumn(name="TYPE", 
//        discriminatorType=DiscriminatorType.STRING,
//        length=2)
//@DiscriminatorValue("P")
@NamedQueries(value ={
    @NamedQuery(name = "Pessoa.buscarTodos",
               query = "from Pessoa p")
})
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "numero")
    private int numero = 10;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "salario", scale = 2)
    private Double salario;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "cargo")
    private Cargo cargo;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "numero=" + numero + ", dataNascimento=" + dataNascimento + ", salario=" + salario + ", id=" + id + ", nome=" + nome + ", cargo=" + cargo +'}';
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.id, other.id);
    }
    
}