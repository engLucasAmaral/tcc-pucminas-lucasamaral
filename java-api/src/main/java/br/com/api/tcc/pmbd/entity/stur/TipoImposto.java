package br.com.api.tcc.pmbd.entity.stur;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tb_tipo_iposto_stur")
public enum TipoImposto {
    IPTU,
    ISS,
    ITR;
}
