
package dev.mikeintoch;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class ServiceRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration().bindingMode(RestBindingMode.json);

        rest("/customer")
                .get()
                .to("direct:getCustomers")

                .post()
                .type(Customer.class)
                .to("direct:addCustomer");

        from("direct:getCustomers")
                .to("jpa://dev.mikeintoch.Person?resultClass=dev.mikeintoch.Customer&namedQuery=findAll")
                .log("Customer List: ${body} ");

        from("direct:addCustomer")
                .to("jpa://dev.mikeintoch.Customer?usePersist=true");
        


    }
}
