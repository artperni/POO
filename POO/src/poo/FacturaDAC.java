package poo;

import java.io.*;
import java.util.*;

public class FacturaDAC 
        extends GlobalDAC
 implements IPersistence, Serializable{

    @Override
    public boolean xmlSerialize(ArrayList<Object> listObj) {
        boolean ok = false;
        if ( super.xmlSerialize(listObj, FAC_SERIALIZE) )
            ok = true;
        return ok;
    }

    @Override
    public Object xmlDeserialize() {
        return super.xmlDeserialize(FAC_SERIALIZE);
    }
    
}
