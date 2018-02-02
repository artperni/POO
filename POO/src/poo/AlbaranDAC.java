package poo;

import java.io.*;
import java.util.ArrayList;

public class AlbaranDAC  
        extends GlobalDAC
        implements IPersistence, Serializable{

    @Override
    public boolean xmlSerialize(ArrayList<Object> listObj) {
         boolean ok = false;
        if ( super.xmlSerialize(listObj, ALB_SERIALIZE) )
            ok = true;
        return ok;
    }

    @Override
    public Object xmlDeserialize() {
        return xmlDeserialize(ALB_SERIALIZE);
    }
    
}
