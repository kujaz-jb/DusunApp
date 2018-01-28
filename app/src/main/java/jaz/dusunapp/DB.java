package jaz.dusunapp;

/**
 * Created by ROG on 1/11/2018.
 */

public class DB {
    public static String[] getData(int id){
        if(id == R.id.action_malay_dusun){
            return getMalayDusun();
        }

        if (id == R.id.action_english_dusun){
            return getEnglishDusun();
        }

        return new String[0];
    }

    public static String [] getMalayDusun(){
        String [] source = new String[]{
                "abad"
                ,"abadi"
                ,"abang"
                ,"abuk"
                ,"ada"
                ,"acar"
                ,"acara"
                ,"acuan"
                ,"adat"
                ,"adik"
                ,"adil"
        };
        return source;
    }

    public static String [] getEnglishDusun(){
        String [] source = new String[]{
                "aba"
                ,"abac"
                ,"abaca"
                ,"abaci"
                ,"abaco"
                ,"abacterial"
                ,"abaculus"
                ,"abaft"

        };
        return source;
    }
}
