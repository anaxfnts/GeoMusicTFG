package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Evento {

<<<<<<< HEAD
  private static final long serialVersionUID = 1L;
=======
 private static final long serialVersionUID = 1L;
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e

  StringProperty nombreEvento;
  StringProperty artista;
  StringProperty ubicacion;
  StringProperty fecha;
  StringProperty imagenEvento;
  StringProperty descripcion;

<<<<<<< HEAD
  public Evento(String nombreEvento, String artista, String ubicacion, String fecha, String imagenEvento,
      String descripcion) {
=======

  public Evento(String nombreEvento, String artista, String ubicacion,
      String fecha, String imagenEvento, String descripcion) {
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
    this.nombreEvento = new SimpleStringProperty(nombreEvento);
    this.artista = new SimpleStringProperty(artista);
    this.ubicacion = new SimpleStringProperty(ubicacion);
    this.fecha = new SimpleStringProperty(fecha);
    this.imagenEvento = new SimpleStringProperty(imagenEvento);
    this.descripcion = new SimpleStringProperty(descripcion);
  }

<<<<<<< HEAD
=======


>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public String getNombreEvento() {
    return nombreEvento.get();
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public void setNombreEvento(String nombre) {
    this.nombreEvento = new SimpleStringProperty(nombre);
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public String getArtista() {
    return artista.get();
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public void setArtista(String artista) {
    this.artista = new SimpleStringProperty(artista);
  }

<<<<<<< HEAD
=======


>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public String getUbicacion() {
    return ubicacion.get();
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public void setUbicacion(String ubicacion) {
    this.ubicacion = new SimpleStringProperty(ubicacion);
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public String getFecha() {
    return fecha.get();
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public void setFecha(String fecha) {
    this.fecha = new SimpleStringProperty(fecha);
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public String getImagenEvento() {
    return imagenEvento.get();
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public void setImagenEvento(String imagenEvento) {
    this.imagenEvento = new SimpleStringProperty(imagenEvento);
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public String getDescripcion() {
    return descripcion.get();
  }

<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  public void setDescripcionr(String descripcion) {
    this.descripcion = new SimpleStringProperty(descripcion);
  }

<<<<<<< HEAD
  @Override
  public String toString() {
    return "Evento [nombreEvento=" + nombreEvento + ", artista=" + artista + ", ubicacion=" + ubicacion + ", fecha="
        + fecha + ", imagenEvento=" + imagenEvento + ", descripcion=" + descripcion + "]";
  }

=======
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
}
