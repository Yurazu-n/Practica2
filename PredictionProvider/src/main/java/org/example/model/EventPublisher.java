package org.example.model;

import org.example.control.MyExecutionException;

public interface EventPublisher {
    void publishEvent(String jsonPrediction) throws MyExecutionException;
}
