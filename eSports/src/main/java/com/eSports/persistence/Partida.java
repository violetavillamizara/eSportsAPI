package com.eSports.persistence;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jugador_id", referencedColumnName = "id",nullable = false)
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "juego_id", referencedColumnName = "id",nullable = false)
    private Juego juego;

    @Column(name = "puntuacion", nullable = false)
    private Long puntuacion;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Partida(){}
    public Partida(Jugador jugador, Juego juego, Long puntuacion, Date fecha) {
        this.jugador = jugador;
        this.juego = juego;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
