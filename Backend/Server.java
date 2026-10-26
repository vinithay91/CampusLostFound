import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Server {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0
        );


        // =========================
        // REGISTER
        // =========================

        server.createContext("/register", exchange -> {

            exchange.getResponseHeaders().add(
                "Access-Control-Allow-Origin", "*"
            );

            if (exchange.getRequestMethod().equals("POST")) {

                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        exchange.getRequestBody()
                    )
                );

                String data = reader.readLine();

                String[] values = data.split(",");

                userDataBase.addUser(
                    values[0],
                    values[1],
                    values[2],
                    values[3]
                );

                String response =
                    "User registered successfully!";

                exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
                );

                exchange.getResponseBody().write(
                    response.getBytes()
                );

                exchange.getResponseBody().close();
            }
        });


        // =========================
        // LOGIN
        // =========================

        server.createContext("/login", exchange -> {

            exchange.getResponseHeaders().add(
                "Access-Control-Allow-Origin", "*"
            );

            if (exchange.getRequestMethod().equals("POST")) {

                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        exchange.getRequestBody()
                    )
                );

                String data = reader.readLine();

                String[] values = data.split(",");

                boolean result =
                    userDataBase.loginUser(
                        values[0],
                        values[1]
                    );

                String response;

                if (result) {

                    response = "Login successful!";

                } else {

                    response =
                        "Invalid email or password!";
                }

                exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
                );

                exchange.getResponseBody().write(
                    response.getBytes()
                );

                exchange.getResponseBody().close();
            }
        });


        // =========================
        // GET USERS
        // =========================

        server.createContext("/users", exchange -> {

            exchange.getResponseHeaders().add(
                "Access-Control-Allow-Origin", "*"
            );

            if (exchange.getRequestMethod().equals("GET")) {

                String response =
                    userDataBase.getUsers();

                exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
                );

                exchange.getResponseBody().write(
                    response.getBytes()
                );

                exchange.getResponseBody().close();
            }
        });


        // =========================
        // ADD LOST ITEM
        // =========================

        server.createContext("/lost-items", exchange -> {

            exchange.getResponseHeaders().add(
                "Access-Control-Allow-Origin", "*"
            );

            if (exchange.getRequestMethod().equals("POST")) {

                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        exchange.getRequestBody()
                    )
                );

                String data = reader.readLine();

                String[] values = data.split(",");

                userDataBase.addLostItem(
                    values[0],
                    values[1],
                    values[2],
                    values[3],
                    values[4],
                    values[5]
                );

                String response =
                    "Lost item added successfully!";

                exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
                );

                exchange.getResponseBody().write(
                    response.getBytes()
                );

                exchange.getResponseBody().close();
            }
        });


        // =========================
        // GET LOST ITEMS
        // =========================

        server.createContext("/lost-items-list", exchange -> {

            exchange.getResponseHeaders().add(
                "Access-Control-Allow-Origin", "*"
            );

            if (exchange.getRequestMethod().equals("GET")) {

                String response =
                    userDataBase.getLostItems();

                exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
                );

                exchange.getResponseBody().write(
                    response.getBytes()
                );

                exchange.getResponseBody().close();
            }
        });


        // =========================
        // ADD FOUND ITEM
        // =========================

        server.createContext("/found-items", exchange -> {

            exchange.getResponseHeaders().add(
                "Access-Control-Allow-Origin", "*"
            );

            if (exchange.getRequestMethod().equals("POST")) {

                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                        exchange.getRequestBody()
                    )
                );

                String data = reader.readLine();

                String[] values = data.split(",");

                userDataBase.addFoundItem(
                    values[0],
                    values[1],
                    values[2],
                    values[3],
                    values[4],
                    values[5]
                );

                String response =
                    "Found item added successfully!";

                exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
                );

                exchange.getResponseBody().write(
                    response.getBytes()
                );

                exchange.getResponseBody().close();
            }
        });


        // =========================
        // GET FOUND ITEMS
        // =========================

        server.createContext(
            "/found-items-list",
            exchange -> {

                exchange.getResponseHeaders().add(
                    "Access-Control-Allow-Origin", "*"
                );

                if (exchange.getRequestMethod().equals("GET")) {

                    String response =
                        userDataBase.getFoundItems();

                    exchange.sendResponseHeaders(
                        200,
                        response.getBytes().length
                    );

                    exchange.getResponseBody().write(
                        response.getBytes()
                    );

                    exchange.getResponseBody().close();
                }
            }
        );


        // =========================
        // START SERVER
        // =========================

        server.start();

        System.out.println(
            "Server started at http://localhost:8080"
        );
    }
}