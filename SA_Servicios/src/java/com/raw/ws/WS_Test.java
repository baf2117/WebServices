
package com.raw.ws;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebMethod;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
/**
 *
 * @author Brayan
 */
@WebService
@SOAPBinding(style =SOAPBinding.Style.RPC)
public class WS_Test {
    private final static String QUEUE_NAME ="SAP2";
    @WebMethod
    public String Solicitud_cliente(String id,int cantidad ) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try  {            
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            //channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "producto: "+id+", cantidad: "+cantidad;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            return "Solicitud recibida";
        }catch(Exception e)        
        {
         return "Solicitud denegada";
        }    
    }
    
    @WebMethod
    public String Catalogo() {
        return " id,producto,precio\n" +
"    1,computadora 17' hp,5000.00\n" +
"    2,computadora 17' dell,7500.00\n" +
"    3,computadora 17' lenovo,3500.00\n" +
"    4,computadora 17' mc,10000.00\n" +
"    5,computadora 17' asus,5500.00\n" +
"    6,computadora 17' alienware, 15000.00\n" +
"    7,computadora 15' lenovo ,5850.00\n" +
"    8,computadora 15' hp, 3500.00";
    }
}
