package br.com.marcelo.moedeira.infra;

import android.app.ProgressDialog;
import android.content.Context;

import br.com.marcelo.moedeira.R;

/**
 * Created by Marcelo on 01/04/2018.
 */

public class TDialog extends ProgressDialog {

    private String mensagem =  "Aguarde...";

    public TDialog(Context context) {
        super(context, R.style.Theme_AppCompat_DayNight_Dialog);
        setIndeterminate(true);
        setMessage(getMensagem());
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
