import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Singleton
@Startup
public class StartupService {
    
    //Aqui foi só pra ver se ta criando as tables (não tem como saber sem insert) certinho, 
    //pode descartar depois

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    @PostConstruct
    public void init() {
        System.out.println("Unidade de persistência inicializada, o JPA deve ter criado a tabela.");
    }
}