package views;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
<<<<<<< HEAD
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
=======

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
import firebase.CRUDFirebaseCuentas;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Cuenta;
import utils.HashPassword;
<<<<<<< HEAD
=======
public class LoginController implements Initializable {
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e

public class LoginController implements Initializable {

  public static BorderPane root;
  private Stage stage;

  // Todos los elementos del Login
  @FXML
  private JFXButton btnCancel;

  @FXML
  private JFXButton btnLogin;

  @FXML
  private JFXButton btnAtras;

  @FXML
  private JFXPasswordField txtPassword;

  @FXML
  private JFXTextField txtUser;

  @FXML
  private Label txtTipo;

  public static Cuenta comprobar;

  // Metodo que realiza y comprueba el login de la cuenta
  @FXML
<<<<<<< HEAD
  void logeo(MouseEvent event) throws IOException, Exception {
=======
  void logeo(MouseEvent event) throws IOException {
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e

    String usuario = txtUser.getText();
    String passwd = txtPassword.getText();
    boolean registrado;
    String hasPass = HashPassword.convertirSHA256(passwd);
    String usuarioConsultado = CRUDFirebaseCuentas.consultarUsuario(usuario);
    String passwdConsultado = CRUDFirebaseCuentas.consultarPasswd(usuario);
<<<<<<< HEAD
=======
    System.out.println(usuarioConsultado);
    System.out.println(passwdConsultado);
    System.out.println(hasPass);
    System.out.println(txtPassword.getText());
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e

    /*

    try {
<<<<<<< HEAD
      if (usuarioConsultado.equalsIgnoreCase(usuario) && passwdConsultado.equalsIgnoreCase(hasPass)) {
=======
      System.out.println(comprobar.toString());
      if (usuarioConsultado.equalsIgnoreCase(usuario) && passwdConsultado.equals(hasPass)) {
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
        registrado = true;
        comprobar = CRUDFirebaseCuentas.obtenerDatosCuenta(usuario);
        // Si coinciden los datos, inicia la vista principal de la aplicacion
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalView.fxml"));
        root = loader.load();
        PrincipalController control = loader.getController();
        Scene escena = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(escena);
        control.init(stage, this, comprobar.getNombre(), root, comprobar.getTipo(), comprobar.getUbicacion());
        stage.show();

        if (this.stage != null) {
          this.stage.close();
        }

      } else if (usuario.isEmpty() || passwd.isEmpty()) {
        registrado = false;
        alertaVacio();

      } else {
        registrado = false;
        alertaError();
      }

      // Mirar aquí
    } catch (NullPointerException e) {
      alertaError();
    }
<<<<<<< HEAD
=======
*/
    if (registrado) {
      // Si coinciden los datos, inicia la vista principal de la aplicacion
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalView.fxml"));
      AnchorPane root = loader.load();
      PrincipalController control = loader.getController();
      Scene escena = new Scene(root);
      Stage stage = new Stage();
      stage.setScene(escena);
      //control.init(stage, this, txtUser.getText(), root, comprobar.getTipo());
      stage.show();

      if (this.stage != null) {
        this.stage.close();
      }

    }
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e

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
    alert.setContentText("Usuario no existe: comprueba tu usuario y tu contraseña.");
    alert.showAndWait();

  }

//Metodo que muestra la alerta de error
  public static void alertaFalloApp() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("App no disponible");
    alert.showAndWait();

  }

//Metodo que muestra la alerta de null
  public static void alertaVacio() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Error");
    alert.setContentText("Campos vacíos");
    alert.showAndWait();

  }

  public void setStage(Stage primaryStage) {
    stage = primaryStage;

  }

  // Inicializa
  @Override
  public void initialize(URL location, ResourceBundle resources) {
<<<<<<< HEAD
=======
    txtUser.setText("badfaceana");
    txtPassword.setText("passAna");
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e

  }

}
