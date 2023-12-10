package org.example.control;

import org.example.control.EvenStoreBuilder;

import javax.jms.JMSException;

public class Main {
    public static void main(String[] args) {
        EvenStoreBuilder evenStoreBuilder = new EvenStoreBuilder();
        try {
            evenStoreBuilder.eventStoreBuild(args[0]);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}