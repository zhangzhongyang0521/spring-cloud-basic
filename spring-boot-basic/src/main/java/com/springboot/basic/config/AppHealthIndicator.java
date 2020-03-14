package com.springboot.basic.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int healthCode = checkHealth();
        if (healthCode < 50) {
            return Health.down().withDetail("Error Code", healthCode).build();
        }
        return Health.up().build();
    }

    private int checkHealth() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
