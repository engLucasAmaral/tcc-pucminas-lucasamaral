package br.com.api.tcc.pmbd.entity.stur;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tb_endereco_imovel_stur")
@NamedQueries({
    @NamedQuery(name = "EnderecoImovel.findAll",
            query = "SELECT t FROM EnderecoImovel t where t.id = :p0"),
})

public class EnderecoImovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "bairro", nullable = false, length = 150)
    private String bairro;

    @Column(name = "cidade", nullable = false)
    private String cidade;
 
    @Column(name = "cep", nullable = false, length = 8)
    private String cep;
    
     @Column(name = "siglaUf", nullable = false, length = 2)
    private String siglaUf;

   
    public EnderecoImovel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    
    

}
