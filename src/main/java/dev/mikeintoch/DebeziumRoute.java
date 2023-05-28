package dev.mikeintoch;

import java.util.Map;

import org.apache.camel.builder.RouteBuilder;

public class DebeziumRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("debezium-postgres:my_connector")
        .log("${body}")
        .choice()
          .when(header("CamelDebeziumOperation").isEqualTo("c"))
              .convertBodyTo(Map.class)
              .to("mongodb:mydb?database={{mongodb.database}}&collection={{mongodb.collection}}&operation=insert");
    }
}