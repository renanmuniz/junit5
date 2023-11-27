package com.junit.renan;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    User user = new User("Renan", 33, false, LocalDate.now().minusYears(33));

    @Test
    @DisplayName("User should be at least 18")
    void user_should_be_at_least_18() {
        assertThat(user.age()).isGreaterThanOrEqualTo(18);
//        assertThat(user.blocked())
//                .as("User %s should not be blocked", user.name())
//                .isFalse();
    }

    @Test
    void user_should_be_renan() {
        assertThat(user.name()).startsWith("Re");
    }
}
