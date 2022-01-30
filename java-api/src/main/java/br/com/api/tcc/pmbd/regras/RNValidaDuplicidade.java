/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.api.tcc.pmbd.regras;

import br.com.api.tcc.pmbd.entity.safim.PessoaFisica;
import br.com.api.tcc.pmbd.exception.APIException;
import br.com.api.tcc.pmbd.service.Service;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RequestScoped
public class RNValidaDuplicidade {

    private final Logger log = LogManager.getLogger();
    @EJB
    private Service service;

    public void validar(@Observes PessoaFisica pessoa) throws APIException {
        log.debug("Verificando CPF");
        PessoaFisica p = service.buscarPorCPF(pessoa.getCpf());
        if (pessoa.getCpf() != null && p != null && !Objects.equals(p.getId(), pessoa.getId())) {
            throw new APIException(30, "CPF ja cadastrado!");

        }
    }
}
