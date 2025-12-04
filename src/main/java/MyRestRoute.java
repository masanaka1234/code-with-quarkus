mport org.apache.camel.builder.RouteBuilder;

public class MyRestRoute extends RouteBuilder {

   @Override
   public void configure() {

       restConfiguration()
               .component("platform-http")
               .contextPath("/")
               .port(8080);

       rest("/hello")
               .get()
               .to("direct:hello");

       from("direct:hello")
               .setHeader("Content-Type", constant("text/plain"))
               .setBody().constant("Hello World from Camel REST DSL");
   }
}

