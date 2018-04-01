package br.com.marcelo.moedeira.infra;

/**
 * Created by Marcelo on 31/03/2018.
 */

public class TString {
    private String string;

    public TString(String string) {
        this.string = string;
    }


    /**
     *
     * @param string
     * @param caracter
     * @param lenght
     * @param side
     * @return
     */
    public static String strPad(String string, char caracter,int lenght, int side){
        if(side == 2){
            if(string.length() == lenght){
                return string;
            }
            while (string.length() < lenght){
                string  = string + caracter;
            }
        }else{
            if(string.length() == lenght){
                return string;
            }
            while (string.length() < lenght){
                string  = caracter + string;
            }
        }
        return string;
    }


    public static String strFirstUp(String string){
        return string.substring(0,1).toUpperCase().concat(string.substring(1));
    }


}
