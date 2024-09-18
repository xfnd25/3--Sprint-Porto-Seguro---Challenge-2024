package org.example.entities;

public class ImagemProblema {
    private Long idImagem;
    private String caminhoImagem; // Caminho ou URL da imagem
    private String descricao; // Descrição fornecida pelo usuário
    private Long usuarioId; // Usuário que enviou a imagem

    public ImagemProblema(Long idImagem, String caminhoImagem, String descricao, Long usuarioId) {
        this.idImagem = idImagem;
        this.caminhoImagem = caminhoImagem;
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }


    public Long getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Long idImagem) {
        this.idImagem = idImagem;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}

