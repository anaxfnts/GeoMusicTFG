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

  // Referencia al panel raíz.
  public static BorderPane root;

  // Referencia al escenario principal.
  private Stage stage;

  // Botón de cancelar.
  @FXML
  private JFXButton btnCancel;

  // Botón de iniciar sesión.
  @FXML
  private JFXButton btnLogin;

  // Botón de crear cuenta.
  @FXML
  private JFXButton btnCrearCuenta;

  // Icono de Facebook.
  @FXML
  private ImageView facebook;

  // Icono de Instagram.
  @FXML
  private ImageView instagram;

  // Icono de Twitter.
  @FXML
  private ImageView twitter;

  /**
   * Maneja el evento de clic para iniciar sesión.
   *
   * @param event El evento de ratón que dispara el método.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  @FXML
  void logeo(MouseEvent event) throws IOException {
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

  /**
   * Maneja el evento de clic para crear cuenta.
   *
   * @param event El evento de ratón que dispara el método.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  @FXML
  void crearCuenta(MouseEvent event) throws IOException {
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

  /**
   * Sale de la aplicación.
   *
   * @param event El evento de ratón que dispara el método.
   */
  @FXML
  void salir(MouseEvent event) {
    Platform.exit();
  }

  /**
   * Método para abrir la web de Facebook.
   *
   * @param event El evento de ratón que dispara el método.
   */
  @FXML
  void webFacebook(MouseEvent event) {
    URL url = null;
    try {
      url = new URL("https://es-es.facebook.com/");
      try {
        Desktop.getDesktop().browse(url.toURI());
      } catch (IOException | URISyntaxException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Método para abrir la web de Instagram.
   *
   * @param event El evento de ratón que dispara el método.
   */
  @FXML
  void webInstagram(MouseEvent event) {
    URL url = null;
    try {
      url = new URL("http://instagram.com/");
      try {
        Desktop.getDesktop().browse(url.toURI());
      } catch (IOException | URISyntaxException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Método para abrir la web de Twitter.
   *
   * @param event El evento de ratón que dispara el método.
   */
  @FXML
  void webTwitter(MouseEvent event) {
    URL url = null;
    try {
      url = new URL("https://twitter.com/?lang=es");
      try {
        Desktop.getDesktop().browse(url.toURI());
      } catch (IOException | URISyntaxException e) {
        e.printStackTrace();
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Muestra una alerta de error.
   */
  public static void alertaError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("Usuario incorrecto");
    alert.showAndWait();
  }

  /**
   * Establece el escenario principal.
   *
   * @param primaryStage El escenario principal de la aplicación.
   */
  public void setStage(Stage primaryStage) {
    stage = primaryStage;
  }
}
