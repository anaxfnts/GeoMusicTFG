package views;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.HashPassword;
import models.Cuenta;
public class LoginController implements Initializable {


  public static BorderPane root;
  private Stage stage;

  // Todos los elementos del Login
  @FXML
  private Button btnCancel;

  @FXML
  private Button btnLogin;

  @FXML
  private Button btnAtras;

  @FXML
  private PasswordField txtPassword;

  @FXML
  private TextField txtUser;

  @FXML
  private Label txtTipo;

  public static Cuenta comprobar;

  // Metodo que realiza y comprueba el login de la cuenta
  @FXML
  void logeo(MouseEvent event) throws IOException {
    String nombre = txtUser.getText();
    String passwd = txtPassword.getText();
    boolean registrado = false;
    String hasPass = HashPassword.convertirSHA256(passwd);
    System.out.println(hasPass);
    System.out.println(txtPassword.getText());

    try {
      System.out.println(comprobar.toString());
      if (comprobar.getNombre().equalsIgnoreCase(nombre) && comprobar.getContraseña().equals(hasPass)) {

        registrado = true;

      }

    } catch (NullPointerException e) {
      // Si no son los datos de la cuenta correctos, muestra una alerta de error
      alertaError();
    }

    if (registrado == true) {
      // Si coinciden los datos, inicia la vista principal de la aplicacion
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalView.fxml"));
      root = loader.load();
      // PrincipalController control = loade.getController();
      Scene escena = new Scene(root);
      Stage stage = new Stage();
      stage.setScene(escena);
      // control.init(stage, this, txtUser.getText(), root, comprobar.getTipo(),
      // comprobar.getImagenEmpleado());
      stage.show();
      if (this.stage != null) {
        this.stage.close();
      }

    }

  }

//Metodo para volver a la pantalla previa de la aplicacion
  @FXML
  void atras(MouseEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PreviaView.fxml"));
    AnchorPane root = loader.load();
    Scene escena = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(escena);
    stage.setMaximized(true);
    stage.getIcons().add(new Image("images/logo.png"));
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

  // Inicializa
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    txtUser.setText(" "); // Luis
    txtPassword.setText(" "); // passLuis

  }

}
