package com.learnbasicjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LearnBasicJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnBasicJavaApplication.class, args);
    }

    /**
     * Scheduled (fixedRate, fixedDeplay, cron, initialDelay)
     * initialDelay = 5000 (5 giây sau khi start mới chạy lần đầu tiên)
     *
     * fixedRate = 1000 // mili giây (Mỗi giây thực hiện một lần)
     *
     * fixedDelay = 1000 // mili giây (1 giây sau khi thực hiện xong sẽ thực hiện lần kế tiếp)
     *
     * cron = “0 * * * * MON-FRI” // “second minute hour date month weekday”
     * Phút đầu tiên các ngày từ thứ 2 đến thứ 6 sẽ thực hiện
     * MON-FRI: liên tục, MON,FRI: rời rạc
     * cron = “0/10 * * * * *” // “second minute hour date month weekday”
     * ( cứ 10s là thực hiện 1 lần )
     *
     * Chỉ sử dụng 1 trong 3 fixedRate, fixedDelay, cron
     *
     * Scheduled method: không tham số và không trả về
     * void method()
     *
     */

}
