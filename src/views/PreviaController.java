package views;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PreviaController {

  public static BorderPane root;
  private Stage stage;

  // Todos los elementos de la primera pantalla
  @FXML
  private JFXButton btnCancel;

  @FXML
  private JFXButton btnLogin;

  @FXML
  private JFXButton btnCrearCuenta;

  @FXML
  private ImageView facebook;

  @FXML
  private ImageView instagram;

  @FXML
  private ImageView twitter;

  @FXML
  void logeo(MouseEvent event) throws IOException {

    // Si pulsa el boton iniciar sesion, carga LoginView
    FXMLLoader loade = new FXMLLoader(getClass().getResource("/views/LoginView.fxml"));
    AnchorPane root = loade.load();
    Scene escena = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(escena);
    stage.show();
    if (this.stage != null) {
      this.stage.close();
    }

  }

  @FXML
  void crearCuenta(MouseEvent event) throws IOException {

    // Si pulsa el boton crear cuenta, carga CrearCuentaView
    FXMLLoader loade = new FXMLLoader(getClass().getResource("/views/CrearCuentaView.fxml"));
    AnchorPane root = loade.load();
    Scene escena = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(escena);
    stage.show();
    if (this.stage != null) {
      this.stage.close();
    }

  }

  // Metodo para salir de la aplicacion
  @FXML
  void salir(MouseEvent event) {
    Platform.exit();
  }

  // Metodo para dirigirse a la web de Facebook
  @FXML
  void webFacebook(MouseEvent event) {
    URL url = null;
    try {
      url = new URL("https://es-es.facebook.com/");
      try {
        Desktop.getDesktop().browse(url.toURI());
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    }
  }

//Metodo para dirigirse a la web de Instagram
  @FXML
  void webInstagram(MouseEvent event) {
    URL url = null;
    try {
      url = new URL("http://instagram.com/");
      try {
        Desktop.getDesktop().browse(url.toURI());
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    }
  }

//Metodo para dirigirse a la web de Twitter
  @FXML
  void webTwitter(MouseEvent event) {
    URL url = null;
    try {
      url = new URL("https://twitter.com/?lang=es");
      try {
        Desktop.getDesktop().browse(url.toURI());
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e1) {
      e1.printStackTrace();
    }
  }

  // Metodo que muestra la alerta de error
  public static void alertaError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("Usuario incorrecto");
    alert.showAndWait();

  }

  public void setStage(Stage primaryStage) {
    stage = primaryStage;

  }

}
