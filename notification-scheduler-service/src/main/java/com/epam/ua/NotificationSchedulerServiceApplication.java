package com.epam.ua;

import com.epam.ua.notify.NotificationTest;
import com.epam.ua.report.ReportingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@EnableEurekaClient
@EnableScheduling
@SpringBootApplication
public class NotificationSchedulerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationSchedulerServiceApplication.class, args);
    }


    @Scheduled(fixedRate = 900000)
    public void scheduleFixedRateTask() throws UnirestException, JsonProcessingException {
        new ReportingService().generateReportAndSendMail();
        System.out.println("Report Generated at - " + System.currentTimeMillis());
    }
}
