package br.com.marcelo.moedeira.infra;

import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;

import java.time.Instant;
import java.util.Date;

/**
 * Created by Marcelo on 31/03/2018.
 */

public class Teste {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        String  nome = "1";
        System.out.println(TString.strPad(nome,'0',10,2));
    }
}
