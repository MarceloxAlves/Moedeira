package br.com.marcelo.moedeira.infra;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Marcelo on 31/03/2018.
 */

public class TDate{


    private SimpleDateFormat displayFormat = new SimpleDateFormat("dd-MM-yyyy");
    private SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Calendar calendario;
    private  Date data;
    private String[] meses = {"janeiro","fevereiro","março","abril","maio","junho","julho", "agosto","setembro","outubro","novembro", "dezembro"};



    public TDate(Date date) {
        calendario = Calendar.getInstance();
        data = date;
        calendario.setTime(data);
    }

    public String displayString()
    {
        return displayFormat.format(this.data);

    }

    public String dataString()
    {
        return dataFormat.format(this.data);

    }

    public int getDia(){
        return  this.calendario.get(calendario.DATE);
    }

    public int getMes(){
        return  this.calendario.get(calendario.MONTH);
    }

    public int getAno(){
        return  this.calendario.get(calendario.YEAR);
    }

    public String getDataFormatWeb(){

       return  retornarDiaSemana()+", "+ TString.strPad(""+getDia(),'0',2,1)+" de "+
               TString.strFirstUp(getMesString(getMes()));
    }

    public String retornarDiaSemana()
    {
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        return pesquisarDiaSemana(diaSemana);
    }

    public String getMesString(int mes){
        return meses[mes];
    }

    //faz a pesquisa, dado um inteiro de 1 a 7
    private String pesquisarDiaSemana(int _diaSemana)
    {
        String diaSemana = null;

        switch (_diaSemana)
        {

            case 1:
            {
                diaSemana = "Domingo";
                break;
            }
            case 2:
            {
                diaSemana = "Segunda";
                break;
            }
            case 3:
            {
                diaSemana = "Terça";
                break;
            }
            case 4:
            {
                diaSemana = "Quarta";
                break;
            }
            case 5:
            {
                diaSemana = "Quinta";
                break;
            }
            case 6:
            {
                diaSemana = "Sexta";
                break;
            }
            case 7:
            {
                diaSemana = "Sábado";
                break;
            }

        }
        return diaSemana;

    }
}
