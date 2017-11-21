package br.com.logic.trilhajeesql.Model;

/**
 *
 * @author Ricardo Vanni
 */
public enum TipoLancamentoEnum {

    CREDITO(1, "CREDITO"),
    DEBITO(2, "DEBITO");

    private final Integer codigo;
    private final String tipo;

    public Integer getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    private TipoLancamentoEnum(Integer codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
