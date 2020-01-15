package com.bespin.dcos.observer.byImplementsObserverable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 변화가 발생하면 이를 인지하기 위해서
 *      Way-1. 주기적으로 요청을 보낼 것인지
 *      Way-2. 아니면 관찰자를 붙여 놓음으로써 변화를 즉각적으로 인지하여 이를 반영할 것인가
 * 를 다루는 패턴
 */
@Slf4j
@SpringBootApplication
public class ObserverApplication implements CommandLineRunner {

    private NewsAgency agency;
    private CNNChannel cnn;
    private NewYorkTimesChannel newYorkTimes;

    @Autowired
    public ObserverApplication(NewsAgency agency, CNNChannel cnn, NewYorkTimesChannel newYorkTimes) {
        this.agency = agency;
        this.cnn = cnn;
        this.newYorkTimes = newYorkTimes;
    }

    public static void main(String[] args) {
        SpringApplication.run(ObserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        agency.subscribe(cnn);
        agency.subscribe(newYorkTimes);

        agency.setNews("HeadLine - BTS should go to the army as well.");
        log.info("-----------------------------------------------------");
        agency.setNews("HeadLine - ManU beats the Wolverhampthon.");
        log.info("-----------------------------------------------------");
        agency.setNews("HeadLine - South Korea beat Uzbekistan.");
    }
}
