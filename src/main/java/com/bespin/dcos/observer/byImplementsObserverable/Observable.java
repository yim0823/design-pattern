package com.bespin.dcos.observer.byImplementsObserverable;

public interface Observable {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();
}
