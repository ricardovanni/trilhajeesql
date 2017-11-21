package br.com.logic.trilhajeesql.UTIL;

import br.com.logic.trilhajeesql.Model.TipoLancamentoEnum;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ricardo Vanni
 */
public abstract class Util {

    public String validarData(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(Boolean.FALSE);

        try {
            Date dt = sdf.parse(data);
            return data;

        } catch (ParseException e) {
            throw new ParseException("Data Invalida!", 0);
        }
    }

    public boolean validarNome(String nome) throws Exception {
        //Regex que define Nome podendo apenas conter caracteres alfabeticos com a primeira letra sendo sempre Maiuscula.
        String pattern = "^[A-Z][a-zãõáéíóúêôãõç]+((?:\\s[a-z]{2,3})?(?:\\s[A-Z][a-zãõáéíóúêôãõç]+))*$";
        Boolean isValido = nome.matches(pattern);

        if (isValido) {
            return isValido;
        } else {
            throw new Exception("Nome Invalido!");
        }
    }

    public Integer validarTipoLancamento(String tipo) throws Exception {
        tipo = Normalizer.normalize(tipo, Normalizer.Form.NFD);
        tipo = tipo.replaceAll("[^\\p{ASCII}]", "");
        tipo = tipo.toUpperCase();

        switch (tipo) {
            case "1":
                return TipoLancamentoEnum.CREDITO.getCodigo();
            case "CREDITO":
                return TipoLancamentoEnum.CREDITO.getCodigo();
            case "2":
                return TipoLancamentoEnum.DEBITO.getCodigo();
            case "DEBITO":
                return TipoLancamentoEnum.DEBITO.getCodigo();
            default:
                throw new Exception("Tipo de Lancamento Invalido!");
        }

    }
}
