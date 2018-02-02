package poo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class GlobalDAC {
    public boolean xmlSerialize(ArrayList<Object> listObj, String path) {
        boolean ok = false;
        XMLEncoder xmle;
        try{
            xmle = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
        }
        catch(FileNotFoundException fileNotFound){
            System.out.println("Error creando o abriendo el fichero");
            return ok;
	}
        xmle.writeObject(listObj);
        xmle.close();
        ok=true;
        return ok;
    }
    public Object xmlDeserialize(String path){
        XMLDecoder xmld=null;
        try{
            xmld = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
        }
        catch(FileNotFoundException fileNotFound){
            System.out.println("Error creando o abriendo el fichero");
	}
        return xmld.readObject();
    }
}
