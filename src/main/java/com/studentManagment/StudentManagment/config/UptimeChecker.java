package com.studentManagment.StudentManagment.config;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class UptimeChecker {

    private final RestTemplate restTemplate = new RestTemplate();
    private final AtomicLong lastResponseTime = new AtomicLong(-1);
    private final String urlToCheck = "https://www.google.com";

    @Scheduled(fixedRate = 6000) // every 60 seconds
    public void checkWebsiteUptime() {
        try {
            long start = System.currentTimeMillis();
            restTemplate.getForEntity(urlToCheck, String.class);
            long duration = System.currentTimeMillis() - start;
            lastResponseTime.set(duration);
            System.out.println("Uptime check: " + duration + "ms");
        } catch (Exception e) {
            lastResponseTime.set(-1); // Indicate failure
            System.out.println("Uptime check failed: " + e.getMessage());
        }
    }

    public long getLastResponseTime() {
        return lastResponseTime.get();
    }

}

