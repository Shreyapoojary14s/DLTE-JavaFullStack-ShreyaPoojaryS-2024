
package web;

import javax.xml.bind.annotation.XmlRegistry;



@XmlRegistry
public class ObjectFactory {



    public ObjectFactory() {
    }

    public Date createDate() {
        return new Date();
    }

    public GroupOfTransactions createGroupOfTransactions() {
        return new GroupOfTransactions();
    }

    public Transaction createTransaction() {
        return new Transaction();
    }

}
