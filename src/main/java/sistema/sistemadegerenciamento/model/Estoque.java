package sistema.sistemadegerenciamento.model;

public class Estoque {

    private Integer id;
    private Long codigo;
    private String produto;
    private Integer quantidade;

    public Estoque(Integer id, Long codigo, String produto, Integer quantidade) {
        this.id = id;
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
