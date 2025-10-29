
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Cargo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CargoDAO extends AbstractDAO<Cargo>{
    
    
    
    public List<Cargo> buscarTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Cargo> q = em.createNamedQuery("Cargo.buscarTodos",
                                                    Cargo.class);
        return q.getResultList();
    }
    
    
    public Cargo buscarPeloId(Integer id){
        EntityManager em = getEntityManager();
        return em.find(Cargo.class, id);
    }
    
    
    
    
    
    
}
