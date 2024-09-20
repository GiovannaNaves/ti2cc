package service;

import dao.TopicoDAO;
import model.Topico;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import java.util.List;

public class TopicoService {

    private TopicoDAO topicoDAO = new TopicoDAO();
    private Gson gson = new Gson();

    public String addTopico(Request req, Response res) {
        Topico topico = gson.fromJson(req.body(), Topico.class);
        if (topicoDAO.insert(topico)) {
            res.status(201); // Criado
            return gson.toJson(topico);
        } else {
            res.status(500); // Erro no servidor
            return "Erro ao adicionar tópico.";
        }
    }

    public String getAllTopicos(Request req, Response res) {
        List<Topico> topicos = topicoDAO.getAll();
        res.status(200); // Sucesso
        return gson.toJson(topicos);
    }
}
