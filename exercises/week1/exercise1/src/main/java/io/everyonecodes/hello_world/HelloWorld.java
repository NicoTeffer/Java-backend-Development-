package io.everyonecodes.hello_world;

import org.springframework.stereotype.Service;

@Service
public class HelloWorld {
    public String get(){
        return "Hello World";
    }
}
