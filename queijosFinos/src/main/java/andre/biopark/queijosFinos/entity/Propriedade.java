package andre.biopark.queijosFinos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "propriedade")

public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String tecnologiasUsadas;
    @Column(nullable = false)
    private int qtdleite;
    @Column(nullable = false)
    private int statusAprovacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTecnologiasUsadas() {
        return tecnologiasUsadas;
    }

    public void setTecnologiasUsadas(String tecnologiasUsadas) {
        this.tecnologiasUsadas = tecnologiasUsadas;
    }

    public int getQtdleite() {
        return qtdleite;
    }

    public void setQtdleite(int qtdleite) {
        this.qtdleite = qtdleite;
    }

    public int getStatusAprovacao() {
        return statusAprovacao;
    }

    public void setStatusAprovacao(int statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
    }
}