package com.junit.renan;

import java.time.LocalDate;

public record User(String name, Integer age, Boolean blocked, LocalDate birthDate) {

}
