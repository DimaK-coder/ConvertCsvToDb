package com.test.beeline.domain;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.test.beeline.converter.LocalDateConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User extends BaseEntity{

//    @CsvBindByPosition(position = 2)
    @Column(name = "name")
    private String name;

//    @CsvBindByPosition(position = 1)
    @Column(name = "postal_code")
    private Integer postalCode;

//    @CsvCustomBindByPosition(position = 3, converter = LocalDateConverter.class)
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
