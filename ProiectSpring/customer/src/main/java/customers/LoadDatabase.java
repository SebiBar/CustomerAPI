package customers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {

        return args -> {
            // tag::new_constructor[]
            log.info("Preloading " + repository.save(new Customer("Bob", "Marcus", "Hello", 20,true, Customer.AccountStatus.GOOD)));
            log.info("Preloading " + repository.save(new Customer("Mercedes", "Benzon", "cakes!", 32,false, Customer.AccountStatus.OK)));
            log.info("Preloading " + repository.save(new Customer("Rahul", "Jones", "wowowow", 19,false, Customer.AccountStatus.BAD)));
            log.info("Preloading " + repository.save(new Customer("Marius", "Ventura", "Morning chat", 24,true, Customer.AccountStatus.RISK)));
            // end::new_constructor[]
        };
    }
}
