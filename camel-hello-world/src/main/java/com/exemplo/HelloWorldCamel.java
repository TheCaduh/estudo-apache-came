package com.exemplo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorldCamel {

    public static void main(String[] args) throws Exception {
        // Criar o contexto do Camel
        CamelContext context = new DefaultCamelContext();

        // Adicionar a rota
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                restConfiguration()
                        .component("netty-http")
                        .port(8080);
                rest("/hello")
                        .get()
                        .to("direct:helloRoute");
                from("direct:helloRoute")
                        .setBody(constant("Hello World from Apache Camel via REST!"));
                // Rota simples: timer que executa a cada 5 segundos
                from("timer:hello?period=5000")
                        .setBody(constant("Hello World from Apache Camel!"))
                        .log("${body}")
                        .to("stream:out"); // Imprime no console
            }
        });

        // Iniciar o contexto
        context.start();
        System.out.println("Apache Camel iniciado! Pressione Ctrl+C para parar.");

        // Manter a aplicação rodando
        Thread.currentThread().join(); // Roda por 30 segundos

        // Parar o contexto
        context.stop();
    }
}

