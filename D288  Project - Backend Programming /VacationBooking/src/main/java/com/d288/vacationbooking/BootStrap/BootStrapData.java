package com.d288.vacationbooking.BootStrap;

import com.d288.vacationbooking.dao.CountryRepository;
import com.d288.vacationbooking.dao.CustomerRepository;
import com.d288.vacationbooking.dao.DivisionRepository;
import com.d288.vacationbooking.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component

public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CountryRepository countryRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, CountryRepository countryRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.countryRepository = countryRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() <= 1) {
            Customer williamPenprase = new Customer("William", "Penprase", "123 Fake St", "95519", "(707)555-5000");
            Customer joeAnderson = new Customer("Joe", "Anderson", "123 Fir St", "95519", "(707)555-5001");
            Customer johnDoe = new Customer("John", "Doe", "123 Redwood St", "95519", "(707)555-5002");
            Customer taraPenprase = new Customer("Tara", "Penprase", "123 Oak St", "95519", "(707)555-5003");
            Customer edwardPenprase = new Customer("Edward", "Penprase", "123 Oak Drive", "95519", "(707)555-5004");

            customerRepository.save(williamPenprase);
            customerRepository.save(joeAnderson);
            customerRepository.save(johnDoe);
            customerRepository.save(taraPenprase);
            customerRepository.save(edwardPenprase);
        }
    }

}
