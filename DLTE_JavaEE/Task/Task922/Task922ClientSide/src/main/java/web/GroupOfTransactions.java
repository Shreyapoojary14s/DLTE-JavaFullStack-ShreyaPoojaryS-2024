
package web;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "groupOfTransactions", propOrder = {
    "transactions"
})
public class GroupOfTransactions {

    @XmlElement(nillable = true)
    protected List<Transaction> transactions;


    public List<Transaction> getTransactions() {
        if (transactions == null) {
            transactions = new ArrayList<Transaction>();
        }
        return this.transactions;
    }

}
