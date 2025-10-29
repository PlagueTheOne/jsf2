package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.CargoDAO;
import br.edu.ifsp.pep.modelo.Cargo;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

// se der um nome, la no html vai ter que especificar.
// se usar o forClass, ele implicitamente sabe quando vc chamar o conversor.
@FacesConverter(forClass = Cargo.class) 
public class CargoConverter implements Converter<Cargo>{

    @Override
    public Cargo getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null){
            return null;
        }
        // obtem o DAO
        CargoDAO cargoDAO = CDI.current().select(CargoDAO.class).get();
        
        // usa do DAO para buscar
        return cargoDAO.buscarPeloId(Integer.valueOf(string));
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Cargo cargo) {
        if (cargo == null){
            return null;
        }
        return cargo.getCodigo().toString();
    }
    
    
    
    
    
}
