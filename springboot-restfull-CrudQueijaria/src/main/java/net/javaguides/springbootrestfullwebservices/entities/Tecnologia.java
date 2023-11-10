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
@Table(name = "tecnologia")

public class Tecnologia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipoQueijo;
    @Column(nullable = false)
    private String processoUtilizado;
    @Column(nullable = false)
    private String modoPreparo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoQueijo() {
        return tipoQueijo;
    }

    public void setTipoQueijo(String tipoQueijo) {
        this.tipoQueijo = tipoQueijo;
    }

    public String getProcessoUtilizado() {
        return processoUtilizado;
    }

    public void setProcessoUtilizado(String processoUtilizado) {
        this.processoUtilizado = processoUtilizado;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }
}
