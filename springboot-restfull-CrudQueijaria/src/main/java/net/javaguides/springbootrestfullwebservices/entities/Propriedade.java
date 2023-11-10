package net.javaguides.springbootrestfullwebservices.entities;

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
@Table(name = "produtor")

public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String ultimaVisita;
    @Column(nullable = false)
    private String proxVisita;
    @Column(nullable = false)
    private String dataVencimentoContrato;
    @Column(nullable = false)
    private String tecnologiasUsadas;
    @Column(nullable = false)
    private String dataRecebimentoCertificado;
    @Column(nullable = false)
    private String nome;
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

    public String getUltimaVisita() {
        return ultimaVisita;
    }

    public void setUltimaVisita(String ultimaVisita) {
        this.ultimaVisita = ultimaVisita;
    }

    public String getProxVisita() {
        return proxVisita;
    }

    public void setProxVisita(String proxVisita) {
        this.proxVisita = proxVisita;
    }

    public String getDataVencimentoContrato() {
        return dataVencimentoContrato;
    }

    public void setDataVencimentoContrato(String dataVencimentoContrato) {
        this.dataVencimentoContrato = dataVencimentoContrato;
    }

    public String getTecnologiasUsadas() {
        return tecnologiasUsadas;
    }

    public void setTecnologiasUsadas(String tecnologiasUsadas) {
        this.tecnologiasUsadas = tecnologiasUsadas;
    }

    public String getDataRecebimentoCertificado() {
        return dataRecebimentoCertificado;
    }

    public void setDataRecebimentoCertificado(String dataRecebimentoCertificado) {
        this.dataRecebimentoCertificado = dataRecebimentoCertificado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
