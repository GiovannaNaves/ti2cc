package model;

public class Topico {
    private int id;
    private String titulo;
    private String conteudo;
    private String imagem;
    private String[] categorias;

    public Topico(int id, String titulo, String conteudo, String imagem, String[] categorias) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.imagem = imagem;
        this.categorias = categorias;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }

    public String[] getCategorias() { return categorias; }
    public void setCategorias(String[] categorias) { this.categorias = categorias; }
}
