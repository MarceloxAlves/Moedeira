package br.com.marcelo.moedeira.infra;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.Instant;

/**
 * Created by Marcelo on 31/03/2018.
 */

public class Teste {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        System.out.println(Instant.now());

    }
}
