package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyReader {

    @Value("${my.custom.property}")
    private String myCustomProperty;

    public String getMyCustomProperty() {
        return myCustomProperty;
    }
}
