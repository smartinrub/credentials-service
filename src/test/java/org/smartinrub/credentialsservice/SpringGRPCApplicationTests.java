package org.smartinrub.credentialsservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartinrub.credentialsservice.client.BCryptClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringGRPCApplicationTests {

    @Autowired
    private BCryptClient bCryptClient;

    @Test
    public void testCheckHashedPassword() {
        assertThat(bCryptClient.checkHashedPassword("Password1")).isEqualTo("Password1");
    }
}
