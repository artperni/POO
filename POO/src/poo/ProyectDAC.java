package poo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class ProyectDAC 
        implements IPersistence, Serializable {

    @Override
    public boolean xmlSerialize(Object listObj, String path) {
        boolean ok = false;
        XMLEncoder xmle;
        try{
            xmle = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
        }
        catch(FileNotFoundException fnf){
            System.out.println("Error creando o abriendo el fichero: "+fnf.getMessage());
            return ok;
	}
        xmle.writeObject(listObj);
        xmle.close();
        ok=true;
        return ok;
    }

    @Override
    public Object xmlDeserialize(String path) {
        XMLDecoder xmld=null;
        try{
            xmld = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
        }
        catch(FileNotFoundException fnf){
            System.out.println("Error creando o abriendo el fichero: "+fnf.getMessage());
	}
        return xmld.readObject();
    }
    
}
