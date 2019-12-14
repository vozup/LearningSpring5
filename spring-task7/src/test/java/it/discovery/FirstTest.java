package it.discovery;

import it.discovery.config.AppConfig;
import it.discovery.fortest.Server;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
@TestPropertySource("classpath:test.properties")
public class FirstTest {
    @Autowired
    private Server server;

    @Value("${server.name:default}")
    private String serverName;

    @Test
    void startTest() {
        Assert.isTrue(server.start(), "Server" + serverName + " start OK");
    }
}
