package poo;

import java.beans.XMLEncoder;
import java.io.*;

public class GlobalDAC {
    public boolean xmlSerialize(Object obj, String path) {
        boolean ok = false;
        XMLEncoder xmle;
        try{
            xmle = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
        }
        catch(FileNotFoundException fileNotFound){
            System.out.println("Error creando o abriendo el fichero");
            return ok;
	}
        xmle.writeObject(obj);
        xmle.close();
        ok=true;
        return ok;
    }
    public boolean xmlDeserialize(Object obj, String path){
        boolean ok = false;
        ok=true;
        return ok;
    }
}
