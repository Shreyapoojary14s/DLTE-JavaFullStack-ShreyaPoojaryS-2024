package block.service.task571;

import java.util.Date;

    public class CreditCard {
        private Long CreditCardNumber;
        private String CreditCardHolder;
        private Date CreditCardExpiry;
        private Integer CreditCardCvv;
        private Integer CreditCardLimit;
        private Integer CreditCardPin;

        public CreditCard(Long creditCardNumber, String creditCardHolder, Date creditCardExpiry, Integer creditCardCvv, Integer creditCardLimit, Integer creditCardPin) {
            CreditCardNumber = creditCardNumber;
            CreditCardHolder = creditCardHolder;
            CreditCardExpiry = creditCardExpiry;
            CreditCardCvv = creditCardCvv;
            CreditCardLimit = creditCardLimit;
            CreditCardPin = creditCardPin;
        }


        @Override
        public String toString() {
            return "CreditCard{" +
                    "CreditCardNumber=" + CreditCardNumber +
                    ", CreditCardHolder='" + CreditCardHolder + '\'' +
                    ", CreditCardExpiry=" + CreditCardExpiry +
                    ", CreditCardCvv=" + CreditCardCvv +
                    ", CreditCardLimit=" + CreditCardLimit +
                    ", CreditCardPin=" + CreditCardPin +
                    '}';
        }

}
