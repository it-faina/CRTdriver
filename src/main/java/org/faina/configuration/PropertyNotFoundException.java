package org.faina.configuration;

public class PropertyNotFoundException extends Exception{
    public PropertyNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
