package com.bespin.dcos.observer.byImplementsObserverable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CNNChannel implements Observer{

    private String news;

    @Override
    public void receiveUpdate(NewsAgency newsAgency) {
        this.news = newsAgency.getNews();
        log.info("### Received by {}, updated news is {} ", this.getClass().getSimpleName(), news);
    }
}
