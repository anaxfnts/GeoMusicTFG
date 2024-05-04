package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Evento {

 private static final long serialVersionUID = 1L;

  StringProperty nombreEvento;
  StringProperty artista;
  StringProperty ubicacion;
  StringProperty fecha;
  StringProperty imagenEvento;
  StringProperty descripcion;


  public Evento(String nombreEvento, String artista, String ubicacion,
      String fecha, String imagenEvento, String descripcion) {
    this.nombreEvento = new SimpleStringProperty(nombreEvento);
    this.artista = new SimpleStringProperty(artista);
    this.ubicacion = new SimpleStringProperty(ubicacion);
    this.fecha = new SimpleStringProperty(fecha);
    this.imagenEvento = new SimpleStringProperty(imagenEvento);
    this.descripcion = new SimpleStringProperty(descripcion);
  }



  public String getNombreEvento() {
    return nombreEvento.get();
  }


  public void setNombreEvento(String nombre) {
    this.nombreEvento = new SimpleStringProperty(nombre);
  }


  public String getArtista() {
    return artista.get();
  }


  public void setArtista(String artista) {
    this.artista = new SimpleStringProperty(artista);
  }



  public String getUbicacion() {
    return ubicacion.get();
  }


  public void setUbicacion(String ubicacion) {
    this.ubicacion = new SimpleStringProperty(ubicacion);
  }


  public String getFecha() {
    return fecha.get();
  }


  public void setFecha(String fecha) {
    this.fecha = new SimpleStringProperty(fecha);
  }


  public String getImagenEvento() {
    return imagenEvento.get();
  }


  public void setImagenEvento(String imagenEvento) {
    this.imagenEvento = new SimpleStringProperty(imagenEvento);
  }


  public String getDescripcion() {
    return descripcion.get();
  }


  public void setDescripcionr(String descripcion) {
    this.descripcion = new SimpleStringProperty(descripcion);
  }

}
