package br.com.marcelo.moedeira.infra;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Marcelo on 31/03/2018.
 */

public class TDate extends Date {



    private static final long serialVersionUID = 1L;
    private SimpleDateFormat displayFormat = new SimpleDateFormat("dd-MM-yyyy");
    private SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

    public TDate(int year, int month, int day)
    {


    }

    public TDate(long currDate)
    {
        super(currDate);
    }

    public String displayString()
    {
        return displayFormat.format(this);

    } // end displayString()

    public String dataString()
    {
        return dataFormat.format(this);

    } // end dataString()

    //retorna o dia da semana dada uma data
    public String retornarDiaSemana(int ano, int mes, int dia)
    {

        Calendar calendario = new GregorianCalendar(ano, mes - 1, dia);
        int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);

        return pesquisarDiaSemana(diaSemana);
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
