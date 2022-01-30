package br.com.api.tcc.pmbd.service;

import br.com.api.tcc.pmbd.dao.DAO;
import br.com.api.tcc.pmbd.dao.TypeQuery;
import br.com.api.tcc.pmbd.entity.safim.PessoaFisica;
import br.com.api.tcc.pmbd.entity.stur.Imovel;
import br.com.api.tcc.pmbd.exception.APIException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author lucas
 */
@Stateless
@LocalBean
public class Service {

    private final Logger log = LogManager.getLogger();

    @EJB
    private DAO dao;

    public List<PessoaFisica> buscarTodos(String nome, String cpf, String email, String nascimento) throws APIException {
        Date dataNascimento = null;
        if (nascimento != null) {
            try {
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                dataNascimento = df.parse(nascimento);
            } catch (ParseException e) {
                throw new APIException(0, "Data de nascimento invalida!");
            }
        }
        log.info("Buscando Pessoa por filtro. Nome: {}, CPF: {}, Email: {}, Data: {}", nome, cpf, email, nascimento);
        return dao.buscarTodos(nome, cpf, email, dataNascimento);
    }

    public PessoaFisica buscarPorId(long id) {
        log.info("Buscando Pessoa por ID: {}", id);
        return (PessoaFisica) dao.buscarEntidade(PessoaFisica.class, id);
    }

    public PessoaFisica buscarPorCPF(String cpf) {
        log.info("Buscando Pessoa por CPF: {}", cpf);
        return (PessoaFisica) dao.buscarEntidade("PessoaFisica.buscarPorCPF", TypeQuery.NAMED_QUERY, cpf);
    }

    public PessoaFisica exclusaoLogica(long id) throws APIException {
        log.info("Exclusão lógica ID: {}", id);
        PessoaFisica pessoa = (PessoaFisica) dao.buscarEntidade(PessoaFisica.class, id);
        if (Objects.isNull(pessoa) || !pessoa.isAtivo()) {
            throw new APIException(0, "Pessoa não encontrada!");
        }

        pessoa.setAtivo(Boolean.FALSE);
        return (PessoaFisica) dao.update(pessoa);
    }

    public PessoaFisica inserirPessoa(PessoaFisica pessoa) throws APIException {
        log.info("Cadastrando pessoa : {}", pessoa);
        return (PessoaFisica) dao.insert(pessoa);
    }

    public PessoaFisica atualizar(PessoaFisica pessoa) throws APIException {
        log.info("Atualizando pessoa : {}", pessoa);
        return (PessoaFisica) dao.update(pessoa);
    }

    public void validaPessoa(PessoaFisica pessoa) {

    }
    
    
    //Imoveis
    
    public Imovel inserirImovel(Imovel imovel) throws APIException {
        log.info("Cadastrando imovel : {}", imovel);
        return (Imovel) dao.insert(imovel);
    }
    
    public Imovel buscarImovelPorId(long id) {
        log.info("Buscando Imovel por ID: {}", id);
        return (Imovel) dao.buscarEntidade(Imovel.class, id);
    } 

    public Imovel buscarPorBairro(String bairro) {
        log.info("Buscando Pessoa por bairro: {}", bairro);
        return (Imovel) dao.buscarEntidade("Imovel.buscarPorBairro", TypeQuery.NAMED_QUERY, bairro);
    }
    
      public Imovel atualizarImovel(Imovel imovel) throws APIException {
        log.info("Atualizando pessoa : {}", imovel);
        return (Imovel) dao.update(imovel);
    }
}
