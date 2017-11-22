package br.com.logic.trilhajeesql.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

/**
 *
 * @author Ricardo Vanni
 */
public class Lancamento implements Serializable {

    private Integer id = 0;

    private String nome = "";
    private String data = "";
    private Double valor = 0D;
    private String tipoLancamento = "";
    @JsonIgnore
    private Integer idTipoLancamento = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public Integer getIdTipoLancamento() {
        return idTipoLancamento;
    }

    public void setIdTipoLancamento(Integer idTipoLancamento) {
        this.idTipoLancamento = idTipoLancamento;
    }
}
