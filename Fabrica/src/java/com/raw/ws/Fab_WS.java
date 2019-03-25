
package com.raw.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebMethod;

@WebService
@SOAPBinding(style =SOAPBinding.Style.RPC)
public class Fab_WS {
    @WebMethod
    public String EnviarRev(String id,int cantidad,String idre ) 
    {
        return "Producto: "+id+",cantidad:"+cantidad+ " enviado al revendedor "+idre;
    }
}
