package com.junit.renan;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    User user;

    @BeforeEach
    void setup() {
        user = new User("Renan", 33, false, Date.valueOf(LocalDate.of(1990, 6, 22)));
    }

    @AfterEach
    void cleanup() {
        user = null;
    }

    @Test
    @DisplayName("User should be at least 18")
    void user_should_be_at_least_18() {
        assertThat(user.age()).isGreaterThanOrEqualTo(18);
//        assertThat(user.blocked())
//                .as("User %s should not be blocked", user.name())
//                .isFalse();

        //comparar json
        assertThatJson(user).isEqualTo("{\"name\":\"Renan\",\"age\":33,\"blocked\":false,\"birthDate\":646023600000}");
    }

    @Test
    void user_should_be_renan() {
        assertThat(user.name()).startsWith("Re");
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 50, 80})
    void all_friends_should_at_list_be_18(int age) {
        assertThat(age).isGreaterThanOrEqualTo(18);
    }

    @Test
    void user_must_be_equal_json() throws IOException {
        File file = new File(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("user.json")).getFile()
        );

        ObjectMapper objectMapper = new ObjectMapper();
        User userPayload = objectMapper.readValue(file, User.class);

        assertThat(userPayload).isEqualTo(user);
    }

    @Test
    @DisplayName("Must throw exception")
    void must_throw_exception_test() {
        assertThatThrownBy(() -> {
            float result = 10 / 0;
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("zero");
    }


}
