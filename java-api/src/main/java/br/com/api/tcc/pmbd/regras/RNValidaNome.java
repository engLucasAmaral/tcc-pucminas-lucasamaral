/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.api.tcc.pmbd.regras;

import br.com.api.tcc.pmbd.entity.safim.PessoaFisica;
import br.com.api.tcc.pmbd.exception.APIException;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RequestScoped
public class RNValidaNome {

    private final Logger log = LogManager.getLogger();

    public void validar(@Observes PessoaFisica pessoa) throws APIException {
        log.debug("Verificando nome");

        if (Objects.nonNull(pessoa)) {
            if (Objects.isNull(pessoa.getNome()) || "".equals(pessoa.getNome()) || pessoa.getNome().length() > 150) {
                throw new APIException(10, "Nome da pessoa invalido ou não informado!");
            }
        }
    }
}
