
package poo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class ProductoDAC   
        implements IPersistence, Serializable{

    @Override
    public boolean xmlSerialize(ArrayList listObj) {
        boolean ok = false;
        XMLEncoder xmle;
        try{
            xmle = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(PRO_SERIALIZE)));
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
    public ArrayList xmlDeserialize() {
        XMLDecoder xmld=null;
        try{
            xmld = new XMLDecoder(new BufferedInputStream(new FileInputStream(PRO_SERIALIZE)));
        }
        catch(FileNotFoundException fnf){
            System.out.println("Error creando o abriendo el fichero: "+fnf.getMessage());
	}
        return (ArrayList <Producto>)xmld.readObject();
    }
}