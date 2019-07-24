package com.lamri.botpoc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BotPocApplicationTest {

    @Test
    public void contextLoads() {
        Assertions.assertThat(true).isTrue();
    }

}
