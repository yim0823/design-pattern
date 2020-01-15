package com.bespin.dcos.observer.withPropertyChangeListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

@Slf4j
@Component
public class PclNewsAgency {

    private String news;
    private PropertyChangeSupport support;

    public PclNewsAgency() {
        this.support = new PropertyChangeSupport(this);
    }

    public void setNews(String news) {

        log.info("## There is a newly news.");

        // the first argument is the name of the observed property.
        // the second argument is its old news, the third is a new news.
        support.firePropertyChange("news", this.news, news);
    }

    public void subscribe(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void unsubscribe(PropertyChangeListener listener) {
        if (!Objects.isNull(listener))
            support.removePropertyChangeListener(listener);
    }
}
