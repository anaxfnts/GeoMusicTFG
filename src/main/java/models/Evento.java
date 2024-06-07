package models;

public class Evento {

  private static final long serialVersionUID = 1L;

  String nombreEvento;
  String artista;
  String ubicacion;
  String fecha;
  String imagenEvento;
  String descripcion;

  public Evento(String nombreEvento, String artista, String ubicacion, String fecha, String imagenEvento,
      String descripcion) {
    this.nombreEvento = nombreEvento;
    this.artista = artista;
    this.ubicacion = ubicacion;
    this.fecha = fecha;
    this.imagenEvento = imagenEvento;
    this.descripcion = descripcion;
  }
  
  public Evento() {
    
  }

  public String getNombreEvento() {
    return nombreEvento;
  }

  public void setNombreEvento(String nombre) {
    this.nombreEvento = nombre;
  }

  public String getArtista() {
    return artista;
  }

  public void setArtista(String artista) {
    this.artista = artista;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getImagenEvento() {
    return imagenEvento;
  }

  public void setImagenEvento(String imagenEvento) {
    this.imagenEvento = imagenEvento;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public String toString() {
    return "Evento [nombreEvento=" + nombreEvento + ", artista=" + artista + ", ubicacion=" + ubicacion + ", fecha="
        + fecha + ", imagenEvento=" + imagenEvento + ", descripcion=" + descripcion + "]";
  }
}
