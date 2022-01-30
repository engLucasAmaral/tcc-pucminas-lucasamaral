
package br.com.api.tcc.pmbd.entity.safim;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tb_pessoa_juridica_safim")
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll",
            query = "SELECT t FROM PessoaJuridica t where t.ativo = true"),
    @NamedQuery(name = "PessoaJuridica.buscarPorCNPJ",
            query = "SELECT t FROM PessoaJuridica t where t.cnpj = :p0")})

public class PessoaJuridica extends Pessoa {
    

    @Column(name = "razaoSocial", nullable = false, length = 300)
    private String razaoSocial;

     @Column(name = "nomeFantasia", nullable = true)
    private String nomeFantasia;
      
    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;
    

     
    @Column(name = "inicioAtividade", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date inicioAtividade;
    
  

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getInicioAtividade() {
        return inicioAtividade;
    }

    public void setInicioAtividade(Date inicioAtividade) {
        this.inicioAtividade = inicioAtividade;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }    
}
