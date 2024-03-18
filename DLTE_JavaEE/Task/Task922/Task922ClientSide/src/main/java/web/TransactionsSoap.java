
package web;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


@WebService(name = "TransactionsSoap", targetNamespace = "http://web/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TransactionsSoap {


    @WebMethod
    @WebResult(name = "GroupOfTransactions", partName = "GroupOfTransactions")
    @Action(input = "http://web/TransactionsSoap/readAllRequest", output = "http://web/TransactionsSoap/readAllResponse")
    public GroupOfTransactions readAll();

}
