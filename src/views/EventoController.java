package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import models.Evento;
import utils.EmailUtility;

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
  private JFXButton favButton;

  @FXML
  private JFXButton reviewButton;

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

  public void markAsFavorite(MouseEvent event) throws FileNotFoundException {
    if (evento != null) {
      System.out.println("Marked as favorite: " + evento.getNombreEvento());

      String artista = evento.getArtista();
      String nombreEvento = evento.getNombreEvento();
      String fecha = evento.getFecha();
      String ubicacion = evento.getUbicacion();
      String descripcion = evento.getDescripcion();

      Image imagen = new Image(new FileInputStream("imagenes" + "/" + evento.getImagenEvento()));

      String detallesEvento = String.format("Event: %s\nArtist: %s\nDate: %s\nLocation: %s\nDescription: %s\n",
          nombreEvento, artista, fecha, ubicacion, descripcion);
      String subject = "Información de tu evento marcado como Favorito: - " + nombreEvento;
      String htmlContent = "<h1>" + nombreEvento + "</h1>" + "<p><strong>Artista:</strong> " + artista + "</p>"
          + "<p><strong>Fecha:</strong> " + fecha + "</p>" + "<p><strong>Ubicacion:</strong> " + ubicacion + "</p>"
          + "<p><strong>Descripcion:</strong> " + descripcion + "</p>" + "<img src='" + imagen
          + "' alt='Event Image'/>";
      String plainText = detallesEvento;

      try {
        EmailUtility.sendEmail("anar27fp@gmail.com", subject, plainText, htmlContent);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Evento marcado como favorito");
        alert.setHeaderText(null);
        alert.setContentText("Email de recordatorio enviado correctamente!");
        alert.showAndWait();
      } catch (Exception e) {
        System.err.println("Error enviando el email de recordatorio: " + e.getMessage());
        Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setTitle("Error");
        errorAlert.setHeaderText("Failed to Send Email Reminder");
        errorAlert
            .setContentText("Hubo un error enviando el correo. Por favor, revisa tu concexión e inténtalo más tarde.");
        errorAlert.showAndWait();
      }
    }
  }

  public void openReviewScreen(MouseEvent event) {
    if (evento != null) {
      try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ReviewScreen.fxml"));
        Parent root = loader.load();

        ReviewController reviewController = loader.getController();
        reviewController.loadReviews(evento.getNombreEvento());

        Stage stage = new Stage();
        stage.setTitle("Reviews publicadas:");
        stage.setScene(new Scene(root));
        stage.getIcons().add(new Image("images/logo.PNG"));
        stage.show();
      } catch (Exception ex) {
        System.err.println("Hubo un error al abrir la ventana: " + ex.getMessage());
        ex.printStackTrace();
      }
    } else {
      System.err.println("Evento no inicializado.");
    }
  }

  public void initialize(URL location, ResourceBundle resources) {
    txtFecha.setEditable(false);
    txtUbicacion.setEditable(false);
  }
}
