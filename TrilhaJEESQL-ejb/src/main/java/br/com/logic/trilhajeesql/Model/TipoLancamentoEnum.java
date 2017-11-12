package br.com.logic.trilhajeesql.Model;

/**
 *
 * @author Ricardo Vanni
 */
public enum TipoLancamentoEnum {
    
    CREDITO(1),
    DEBITO(2);
  
    private final Integer codigo;

    public Integer getCodigo() {
        return codigo;
    }

    private TipoLancamentoEnum(Integer codigo) {
        this.codigo = codigo;
    }
}
