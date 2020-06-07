package org.example.app;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    public void configure() {

        from("timer:mytimer?repeatCount=1")
                .setHeader("To", constant("anyone@example.com"))
                .setHeader("From", constant("self@example.com"))
                .setHeader("Subject", constant("Test email Subject"))

                .setBody(constant("TEST BODY"))
                .toD("smtp://localhost:25");

    }
}

