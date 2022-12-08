package com.company.customer.service;

import com.company.clients.fraud.FraudClient;
import com.company.clients.fraud.model.FraudCheckResponse;
import com.company.clients.notification.NotificationClient;
import com.company.customer.model.Customer;
import com.company.customer.model.CustomerRegistrationRequest;
import com.company.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final FraudClient fraudClient;
    private NotificationClient notificationClient;
    private CustomerRepository customerRepository;
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();

        // TODO: 12/7/22 check if email is valid
        // TODO: 12/7/22 check if email not taken

        /*FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );*/

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (Boolean.TRUE.equals(fraudCheckResponse.isFraudster())) {
            throw new IllegalStateException("Fraudster");
        }
        customerRepository.save(customer);

        notificationClient.notification(customer.getId());

    }
}
