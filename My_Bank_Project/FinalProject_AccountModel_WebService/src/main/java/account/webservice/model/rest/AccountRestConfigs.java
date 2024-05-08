package account.webservice.model.rest;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

public class AccountRestConfigs {
    @Configuration
    public class CreditCardConfig {
        @Bean
        public MessageSource messageSource() {
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasename("account");
            messageSource.setDefaultEncoding("UTF-8");
            return messageSource;
        }

        @Bean
        public LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
            LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
            bean.setValidationMessageSource(messageSource);
            return bean;
        }


    }
}
