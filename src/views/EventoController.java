package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
<<<<<<< HEAD
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
=======

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import models.Evento;

public class EventoController {

  private Evento evento = null;
<<<<<<< HEAD
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
  @FXML
  private Label lblNombreEvento;

  @FXML
  private Label lblArtista;

  @FXML
  private Label lblDescripcion;

  @FXML
<<<<<<< HEAD
  private JFXTextField txtFecha;

  @FXML
  private JFXTextField txtUbicacion;
=======
  private TextField txtFecha;

  @FXML
  private TextField txtUbicacion;
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e

  @FXML
  private ImageView img;

  @FXML
  private Rectangle cuadrado;

  public void setDatos(Evento eventos) throws FileNotFoundException {
    evento = eventos;
<<<<<<< HEAD
=======
    //lblID.setText(String.valueOf(evento.getIEvento()));
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
    lblNombreEvento.setText(eventos.getNombreEvento());
    lblDescripcion.setText(eventos.getDescripcion());
    lblArtista.setText(eventos.getArtista());
    txtFecha.setText(eventos.getFecha());
    txtUbicacion.setText(eventos.getUbicacion());
<<<<<<< HEAD

    Image imagen = new Image(new FileInputStream("imagenes" + "/" + eventos.getImagenEvento()));
=======
    Image imagen = new Image(new FileInputStream("imagenes" + "/" + eventos.getImagenEvento()));
    img.setImage(imagen);
    img.setVisible(false);
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
    cuadrado.setFill(new ImagePattern(imagen));

  }

  // Metodo que inicializa los datos
  public void initialize(URL location, ResourceBundle resources) {
    txtFecha.setEditable(false);
    txtUbicacion.setEditable(false);

  }

}
