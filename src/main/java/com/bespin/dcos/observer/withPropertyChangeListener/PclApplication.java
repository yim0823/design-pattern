package com.bespin.dcos.observer.withPropertyChangeListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class PclApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PclApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        PclNewsAgency agency = new PclNewsAgency();
        PclCNNChannel cnn = new PclCNNChannel();
        PclNewYorkTimesChannel times = new PclNewYorkTimesChannel();

        agency.subscribe(cnn);
        agency.subscribe(times);

        agency.setNews("HeadLine - BTS should go to the army as well.");
        log.info("-----------------------------------------------------");
        agency.setNews("HeadLine - ManU beats the Wolverhampthon.");
        log.info("-----------------------------------------------------");
        agency.setNews("HeadLine - South Korea beat Uzbekistan.");
    }
}
