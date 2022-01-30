package br.com.api.tcc.pmbd.response;

import java.io.Serializable;

/**
 *
 * @author lucas
 */
public class Message implements Serializable {

    private long codigo;
    private String descricao;

    public Message() {
    }

    public Message(long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
