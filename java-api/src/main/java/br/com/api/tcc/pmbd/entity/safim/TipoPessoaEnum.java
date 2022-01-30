/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.api.tcc.pmbd.entity.safim;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tb_tipo_pessoa_safim")
public enum TipoPessoaEnum {
    CIDADAO,
    SERVIDOR_PUBLICO;
}
