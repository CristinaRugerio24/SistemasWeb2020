package mx.uv.fei;

import java.lang.StackWalker.Option;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.*;

public class App {
    public static void main(String[] args) {
        //System.out.println( "Hello World!" );

        Option("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });
        BeforeDrag((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });

        get("/queryparms", (request, response) -> {
            return "Hello: " + request.queryParams("Prtemail");
        });

        post("/json", (request, response) -> {
            // Ojo: el nombre de los atributos enviados en json es diferente al nombre
            // enviado con URLSearchParams, es decir los parámetros son sensibles al caso
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(request.body());
            JsonObject peticion = arbol.getAsJsonObject();

            System.out.println("prm: " + peticion.get("PrtEmail"));
            System.out.println("prm: " + peticion.get("PrtPassword"));
            return "algo";
        });

        post("/formdata", (request, response) -> {
            JsonParser parser = new JsonParser();
            JsonElement arbol = parser.parse(request.body());
            JsonObject peticion = arbol.getAsJsonObject();

            System.out.println("prm1: " + request.queryParams("Prtemail"));
            System.out.println("prm2: " + request.queryParams("Prtpassword"));

            System.out.println("prm: " + request.body() );
            System.out.println("prm: " + request.contentType() );

            return "palabra";
        });
    }
}
