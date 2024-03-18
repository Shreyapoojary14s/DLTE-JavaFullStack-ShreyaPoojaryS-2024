
package web;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;



@WebServiceClient(name = "TransactionsSoapService", targetNamespace = "http://web/", wsdlLocation = "http://localhost:1234/wealthWarriors?wsdl")
public class TransactionsSoapService
    extends Service
{

    private final static URL TRANSACTIONSSOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException TRANSACTIONSSOAPSERVICE_EXCEPTION;
    private final static QName TRANSACTIONSSOAPSERVICE_QNAME = new QName("http://web/", "TransactionsSoapService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:1234/wealthWarriors?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRANSACTIONSSOAPSERVICE_WSDL_LOCATION = url;
        TRANSACTIONSSOAPSERVICE_EXCEPTION = e;
    }

    public TransactionsSoapService() {
        super(__getWsdlLocation(), TRANSACTIONSSOAPSERVICE_QNAME);
    }

    public TransactionsSoapService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRANSACTIONSSOAPSERVICE_QNAME, features);
    }

    public TransactionsSoapService(URL wsdlLocation) {
        super(wsdlLocation, TRANSACTIONSSOAPSERVICE_QNAME);
    }

    public TransactionsSoapService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRANSACTIONSSOAPSERVICE_QNAME, features);
    }

    public TransactionsSoapService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TransactionsSoapService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }


    @WebEndpoint(name = "TransactionsSoapPort")
    public TransactionsSoap getTransactionsSoapPort() {
        return super.getPort(new QName("http://web/", "TransactionsSoapPort"), TransactionsSoap.class);
    }

    @WebEndpoint(name = "TransactionsSoapPort")
    public TransactionsSoap getTransactionsSoapPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://web/", "TransactionsSoapPort"), TransactionsSoap.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRANSACTIONSSOAPSERVICE_EXCEPTION!= null) {
            throw TRANSACTIONSSOAPSERVICE_EXCEPTION;
        }
        return TRANSACTIONSSOAPSERVICE_WSDL_LOCATION;
    }

}
