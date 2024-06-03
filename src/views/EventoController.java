package views;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.mail.MessagingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import firebase.CRUDFirebase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import models.Emails;
import models.Evento;

public class EventoController {

  private Evento evento = null;
  private String correoUsuario;

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


//Metodo que permite enviar un email al cliente
@FXML
void enviarEmailCliente(MouseEvent event) throws IOException, MessagingException {
   // Obtener el nombre de usuario
   correoUsuario = LoginController.mostrarNombreUsuario();
   System.out.println("Correo usuario obtenido: " + correoUsuario);
   
   // Verificar si el usuario es nulo
   if (correoUsuario == null) {
       System.err.println("Usuario no inicializado.");
       alertaErrorCorreo();
       return;
   }
   
   // Consultar el correo del usuario
   String correo = CRUDFirebase.consultarCorreo(correoUsuario);
   System.out.println("Correo obtenido de Firebase: " + correo);
   
   // Verificar si el correo es nulo
   if (correo == null || correo.isEmpty()) {
       System.err.println("Correo no encontrado para el usuario: " + correoUsuario);
       alertaErrorCorreo();
       return;
   }
   
   try {
       // Enviar el email
       Emails e = new Emails();
       e.enviar(correo, 
           "Evento marcado como Favorito: " + evento.getNombreEvento(),
           "Estimado usuario, \n" +
           "Aquí está toda la información resumida acerca del evento: \n\n" +
           "Artista: " + evento.getArtista() + "\n" +
           "Fecha: " + evento.getFecha() + "\n" +
           "Ubicación: " + evento.getUbicacion() + "\n" +
           "Descripción: " + evento.getDescripcion() + "\n\n" +
           "Descripción: " + evento.getDescripcion() + "\n\n" +
           "¡Esperamos que disfrutes del evento!"
       );
       alertaEnviado();
   } catch (Exception e) {
       System.err.println("Error enviando el correo: " + e.getMessage());
       e.printStackTrace();
       alertaErrorCorreo();
   }
}

  // Metodo que muestra una alerta de error cuando no se envia el correo 
  private static void alertaErrorCorreo() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("Correo electrónico no enviado. Por favor, inténtalo más tarde.");
    alert.showAndWait();
  }

  // Metodo que confirma que se ha enviado el correo
  private static void alertaEnviado() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Correo electrónico enviado");
    alert.setContentText("Comprueba tu bandeja de entrada.");
    alert.showAndWait();
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
