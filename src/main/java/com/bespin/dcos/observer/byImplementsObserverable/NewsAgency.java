package com.bespin.dcos.observer.byImplementsObserverable;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Getter
@Component
public class NewsAgency implements Observable {

    private String news;
    private List<Observer> observerList = new ArrayList<>();

    public void setNews(String news) {

        log.info("## There is a newly news.");

        this.news = news;
        notifyObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        if (!Objects.isNull(observer))
            observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {

        log.info("## We're gonna notify news-channels.");

        observerList.forEach((observer -> {
            observer.receiveUpdate(this);
        }));
    }
}
