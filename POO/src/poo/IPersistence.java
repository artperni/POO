package poo;


/*Para la serializacion y deserialización es necesaria la carpeta data*/
public interface IPersistence {
    public final String ALB_SERIALIZE="./data/albaran.xml";
    public final String ALM_SERIALIZE="./data/almacen.xml";
    public final String CLI_SERIALIZE="./data/cliente.xml";
    public final String FAC_SERIALIZE="./data/factura.xml";
    public final String PRO_SERIALIZE="./data/producto.xml";
    public final String USR_SERIALIZE="./data/usuario.xml";
    public final String VEN_SERIALIZE="./data/ventas.xml";
    public boolean xmlSerialize(Object listObj, String path);
    public Object xmlDeserialize(String path);
}
