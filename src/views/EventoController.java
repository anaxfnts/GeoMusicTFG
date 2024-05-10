package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import models.Evento;

public class EventoController {

  private Evento evento = null;
  @FXML
  private Label lblNombreEvento;

  @FXML
  private Label lblArtista;

  @FXML
  private Label lblDescripcion;

  @FXML
  private JFXTextField txtFecha;

  @FXML
  private JFXTextField txtUbicacion;

  @FXML
  private ImageView img;

  @FXML
  private Rectangle cuadrado;

  public void setDatos(Evento eventos) throws FileNotFoundException {
    evento = eventos;
    lblNombreEvento.setText(eventos.getNombreEvento());
    lblDescripcion.setText(eventos.getDescripcion());
    lblArtista.setText(eventos.getArtista());
    txtFecha.setText(eventos.getFecha());
    txtUbicacion.setText(eventos.getUbicacion());

    Image imagen = new Image(new FileInputStream("imagenes" + "/" + eventos.getImagenEvento()));
    cuadrado.setFill(new ImagePattern(imagen));

  }

  // Metodo que inicializa los datos
  public void initialize(URL location, ResourceBundle resources) {
    txtFecha.setEditable(false);
    txtUbicacion.setEditable(false);

  }

}
