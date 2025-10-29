
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa>{
    
    
    
    public List<Pessoa> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> q = em.createNamedQuery("Pessoa.buscarTodos",
                                                    Pessoa.class);
        return q.getResultList();
    }
    
    
    
    
    
}
