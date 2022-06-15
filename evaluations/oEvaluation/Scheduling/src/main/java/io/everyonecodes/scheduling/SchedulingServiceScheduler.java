package io.everyonecodes.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingServiceScheduler {

    private  final SchedulingService schedulingService;

    public SchedulingServiceScheduler(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @Scheduled(fixedRate = 2000L)
    public String getMessage2(){
        return schedulingService.getMessage2();
    }

    @Scheduled(fixedDelay = 5000L)
    public String getMessage1(){
        return schedulingService.getMessage1();
    }

    @Scheduled(cron = "0/30 0/2 9-18 * MON-FRI")
    public String getMessage3(){
        return schedulingService.getMessage3();
    }
}
