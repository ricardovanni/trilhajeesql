package br.com.logic.trilhajeesql.Model;

import java.io.Serializable;

/**
 *
 * @author Ricardo Vanni
 */
public class Lancamento implements Serializable {

    private String nome = "";
    private String data = "";
    private Double valor = 0D;
    private Integer tipoLancamento = 0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(Integer tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }
}
