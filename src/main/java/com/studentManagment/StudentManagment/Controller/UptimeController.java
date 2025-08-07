package com.studentManagment.StudentManagment.Controller;

import com.studentManagment.StudentManagment.config.UptimeChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UptimeController {

    private final UptimeChecker uptimeChecker;

    @GetMapping("/uptime")
    public String getUptime() {
        long responseTime = uptimeChecker.getLastResponseTime();
        if (responseTime == -1) {
            return "Website is currently DOWN or unreachable.";
        }
        return "Latest response time: " + responseTime + "ms";
    }
}