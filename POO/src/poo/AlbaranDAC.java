package poo;

import java.io.*;

public class AlbaranDAC  
        extends GlobalDAC
        implements IPersistence, Serializable{

    @Override
    public boolean xmlSerialize(Object obj) {
         boolean ok = false;
        if ( super.xmlSerialize(obj, ALB_SERIALIZE) )
            ok = true;
        return ok;
    }

    @Override
    public boolean xmlDeserialize(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
