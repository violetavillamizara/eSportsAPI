package com.eSports.persistence;

import jakarta.persistence.*;

@Entity
@Table(name="entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "experiencia_years", nullable = false)
    private Long experienciaYears;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_id", referencedColumnName = "id", nullable = false)
    private Equipo equipo;

    public Entrenador(){}

    public Entrenador(String nombre, Long experienciaYears, Equipo equipo) {
        this.nombre = nombre;
        this.experienciaYears = experienciaYears;
        this.equipo = equipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getExperienciaYears() {
        return experienciaYears;
    }

    public void setExperienciaYears(Long experienciaYears) {
        this.experienciaYears = experienciaYears;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
