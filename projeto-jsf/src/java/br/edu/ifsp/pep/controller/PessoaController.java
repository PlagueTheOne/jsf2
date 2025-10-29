package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CargoDAO;
import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.modelo.Cargo;
import br.edu.ifsp.pep.modelo.Pessoa;
import br.edu.ifsp.pep.util.Message;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;



/**
 *
 * @author aluno
 */
@Named(value = "pessoaController")
//@SessionScoped // precisa de serializable //cria um new a cada sessão
@RequestScoped // nao precisa de serializable // cria um new a cada requisicao
public class PessoaController implements Serializable{
    
    @Inject
    private PessoaDAO pessoaDAO;
   
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private List<Cargo> cargos;
    
    
    public PessoaController() {
        // como eh um atributo comum, pessoa precisa ser instanciado
        // ja pessoaDAO nao, isso se da por conta do @inject
        // que faz com que o glassfish instancie
        this.pessoa = new Pessoa(); 
    }

//    public PessoaDAO getPessoaDAO() {
//        return pessoaDAO;
//    }

//    public void setPessoaDAO(PessoaDAO pessoaDAO) {
//        this.pessoaDAO = pessoaDAO;
//    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public void incrementar(){
        pessoa.setNumero(pessoa.getNumero() + 1);
    }
    
    public String cadastrar(){
        System.out.println("METODO EXIBIR");
        System.out.println("NUMERO: " + pessoa.getNumero());
        System.out.println("NOME: " + pessoa.getNome());
        System.out.println("PESSOA:" + pessoa.toString());
        
        pessoaDAO.inserir(pessoa);
        pessoa = new Pessoa();
        Message.sucesso("Pessoa cadastrada!");
        return "/pessoa/listagem";
        
    }

    public List<Pessoa> getPessoas() {
        if (this.pessoas == null){
            System.out.println("acessando banco");
            this.pessoas = pessoaDAO.buscarTodos();
        }
        System.out.println(pessoas);
        return this.pessoas;
    }
    
    
    
    public void excluirPessoa(Pessoa pessoa){
        System.out.print("==============================EXCLUIR\n");
        pessoaDAO.excluir(pessoa);
        this.pessoas = pessoaDAO.buscarTodos();
        Message.sucesso("Pessoa excluida");
        System.out.println(pessoa);
        
    }
    
    public String buscarCargoPorNome(){
        return "";
    }
    
    
    
}
