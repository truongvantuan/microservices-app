package com.company.customer.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author truongtuan
 */
@Data
@Builder
public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
