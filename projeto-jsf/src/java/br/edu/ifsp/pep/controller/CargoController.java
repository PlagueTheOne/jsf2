/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CargoDAO;
import br.edu.ifsp.pep.modelo.Cargo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author aluno
 */

@Named
@RequestScoped
public class CargoController {
    
    
    @Inject
    private CargoDAO cargoDAO;
    
    public List<Cargo> getCargos() {
        return cargoDAO.buscarTodos();
    }
    
    
}
