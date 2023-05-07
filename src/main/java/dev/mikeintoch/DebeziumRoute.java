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
              .process(exchange -> {
                  // Transform the data to a format suitable for MongoDB
                  Map<String, Object> data = exchange.getIn().getBody(Map.class);
                  data.remove("updated_at");
                  data.remove("created_at");
                  data.remove("phone");
                  exchange.getIn().setBody(data);
                })
              .to("mongodb:mydb?database={{mongodb.database}}&collection={{mongodb.collection}}&operation=insert");
    }
}