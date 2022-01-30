package br.com.api.tcc.pmbd.entity.safim;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "tb_pessoa_fisica_safim")
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll",
            query = "SELECT t FROM PessoaFisica t where t.ativo = true"),
    @NamedQuery(name = "PessoaFisica.buscarPorCPF",
            query = "SELECT t FROM PessoaFisica t where t.cpf = :p0")})

public class PessoaFisica extends Pessoa {

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "cargo", nullable = true)
    private String cargo;

    @Column(name = "nascimento", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Column(name = "sexo", nullable = true)
    private String sexo;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipoPessoa", nullable = true)
    private TipoPessoaEnum tipoPessoa;

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public TipoPessoaEnum getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

}
