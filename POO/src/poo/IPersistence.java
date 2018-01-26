package poo;

public interface IPersistence {
    public final String ALB_SERIALIZE="./data/albaran.xml";
    public final String ALM_SERIALIZE="./data/almacen.xml";
    public final String CLI_SERIALIZE="./data/cliente.xml";
    public final String FAC_SERIALIZE="./data/factura.xml";
    public boolean xmlSerialize(Object obj);
    public boolean xmlDeserialize(Object obj);
}
