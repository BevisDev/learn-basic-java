package com.learnbasicjava.bean;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class Student {
    @Email
    // blank : maybe 1 space
    @NotBlank(message = "vui long ko bo trong")
    String email;
    @NotBlank
    String fullname;
    @NotNull(message = "Vui long nhap diem")
    @Min(0)
    @Max(10)
    Double marks;
    @NotNull()
    Boolean gender;
    @NotEmpty
    String country;
}