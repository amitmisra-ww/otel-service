package com.example.otelservice.service;

import org.springframework.stereotype.Service;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.extension.annotations.SpanAttribute;
import io.opentelemetry.extension.annotations.WithSpan;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingService {
    @WithSpan
    public String greet(@SpanAttribute String name) {
        Span.current().setAttribute("param-name", name);
        log.info("greet service invoked");
        return String.format("Hello %s", name);
    }
}
