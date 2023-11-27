package com.junit.renan;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public record User(String name, Integer age, Boolean blocked, Date birthDate) {
}

