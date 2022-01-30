package br.com.api.tcc.pmbd.entity.stur;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tb_imovel_stur")
@NamedQueries({
    @NamedQuery(name = "Imovel.findId",
            query = "SELECT t FROM Imovel t where t.id = :p0"),
    @NamedQuery(name = "Imovel.buscarPorBairro",
            query = "SELECT t FROM Imovel t where t.bairro = :p0")})

public class Imovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    
     @Column(name = "bairro", nullable = false, length = 150)
    private String bairro;
     
    @Column(name = "cpf", nullable = true)
    private String cpf;

    @Column(name = "cnpj", nullable = true)
    private String cnpj;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipoImovel", nullable = false)
    private TipoImovelEnum tipoImovel;

    @Column(name = "inscricaoMunicipal", nullable = false)
    private String inscricaoMunicipal;
    
       
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_imovel_id", nullable = false)
    private EnderecoImovel enderecoImovel;

    @Column(name = "dataVistoria", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVistoria;
    
    

    @Column(name = "areaTotal", nullable = false)
    private Double areaTotal;
    
      @Column(name = "areaConstruida", nullable = false)
    private Double areaConstruida;
      
       @Column(name = "valorImovel", nullable = false)
    private Double valorImovel;
       
    @Column(name = "valorUltimoImposto", nullable = false)
    private Double valorUltimoImposto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public TipoImovelEnum getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovelEnum tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getInscricaoMunicipal() {
        return inscricaoMunicipal;
    }

    public void setInscricaoMunicipal(String inscricaoMunicipal) {
        this.inscricaoMunicipal = inscricaoMunicipal;
    }

    public EnderecoImovel getEnderecoImovel() {
        return enderecoImovel;
    }

    public void setEnderecoImovel(EnderecoImovel enderecoImovel) {
        this.enderecoImovel = enderecoImovel;
    }

    public Date getDataVistoria() {
        return dataVistoria;
    }

    public void setDataVistoria(Date dataVistoria) {
        this.dataVistoria = dataVistoria;
    }

    public Double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(Double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public Double getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(Double areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public Double getValorImovel() {
        return valorImovel;
    }

    public void setValorImovel(Double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public Double getValorUltimoImposto() {
        return valorUltimoImposto;
    }

    public void setValorUltimoImposto(Double valorUltimoImposto) {
        this.valorUltimoImposto = valorUltimoImposto;
    }  

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    

}
