package com.model;

import lombok.*;
import java.io.Serializable;

/**
 * This class represents address-model
 * @author Svyatoslav Sabirov.
 * @since 23.11.2018
 * @version 10.
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = -5862926644813433707L;
    private long id;
    private int index;
    private String city;
    private String street;
    private int houseNumber;

}
