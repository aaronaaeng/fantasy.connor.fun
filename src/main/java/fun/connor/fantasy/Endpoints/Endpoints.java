package fun.connor.fantasy.Endpoints;

import static spark.Spark.*;

public class Endpoints {
    public static void Serve() {
        get("/hello", (req, res) -> {
            System.out.println("get received");
            return "Hello World";
        });

        post("/create_bowler", (req, res) -> {
            System.out.println("get received");
            return "Hello World";
        });
    }
}
