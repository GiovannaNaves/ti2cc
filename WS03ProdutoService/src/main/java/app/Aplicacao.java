package app;

import static spark.Spark.*;
import service.TopicoService;

public class Aplicacao {

    public static void main(String[] args) {
        port(3001);
        staticFiles.location("/public");

        TopicoService topicoService = new TopicoService();

        // Rotas
        post("/topicos", (req, res) -> topicoService.addTopico(req, res));
        get("/topicos", (req, res) -> topicoService.getAllTopicos(req, res));
    }
}
