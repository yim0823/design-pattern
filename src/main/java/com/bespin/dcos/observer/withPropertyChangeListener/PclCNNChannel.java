package com.bespin.dcos.observer.withPropertyChangeListener;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Slf4j
@Setter
@Component
public class PclCNNChannel implements PropertyChangeListener {

    private String news;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        this.setNews(evt.getNewValue().toString());
        log.info("### Received by {}, updated news is {} ", this.getClass().getSimpleName(), news);
    }
}
