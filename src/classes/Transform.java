package classes;

import java.util.ArrayList;

/**
 * Created by Klincaja on 26/10/16.
 * Suplemento de la libreria JSON NO LA PUDE HACER ANDAR
 */
public class Transform {


    public static String getToStringArray(ArrayList<String> arrayList){
        String aux = "{";
        for(String s: arrayList){
            aux = aux + s +",";
        }
        if(aux.length()>0){
            aux = aux.substring(0,aux.length()-1);
        }
        aux = aux + "}";
        return aux;
    }

    public static ArrayList<String> getArrayListToString(String json){
        ArrayList<String> aux = new ArrayList<String>();
        String object = "";
        for(int i = 1 ; i<json.length(); i++){
            if(json.toCharArray()[i] != ','){
                object = object + json.toCharArray()[i];
            }else {
                aux.add(object);
                object = "";
            }
        }
        aux.add(object.substring(0,object.indexOf('}')));
        return aux;
    }
}
