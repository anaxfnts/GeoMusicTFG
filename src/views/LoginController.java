package views;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import firebase.CRUDFirebase;
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

public class LoginController implements Initializable {

  // Referencia al panel raíz.
  public static BorderPane root;

  // Referencia al escenario principal.
  private Stage stage;

  // Variable para almacenar la ubicación seleccionada.
  private String ubicacionSeleccionada;

  // Botón de cancelar.
  @FXML
  private JFXButton btnCancel;

  // Botón de iniciar sesión.
  @FXML
  private JFXButton btnLogin;

  // Botón de ir atrás.
  @FXML
  private JFXButton btnAtras;

  // Campo de contraseña.
  @FXML
  private JFXPasswordField txtPassword;

  // Campo de usuario.
  @FXML
  private JFXTextField txtUser;

  // Label de tipo.
  @FXML
  private Label txtTipo;

  // Variable para comprobar la cuenta.
  public static Cuenta comprobar;

  // Variable para almacenar el correo del usuario logueado.
  public static String loggedInUserMail = ""; // CRUDFirebase.consultarCorreo(Cuenta.getUsuario());

  // Método que realiza y comprueba el login de la cuenta.
  @FXML
  void logeo(MouseEvent event) throws IOException, Exception {

    String usuario = txtUser.getText();
    String passwd = txtPassword.getText();
    boolean registrado;
    String hasPass = HashPassword.convertirSHA256(passwd);
    String usuarioConsultado = CRUDFirebase.consultarUsuario(usuario);
    String passwdConsultado = CRUDFirebase.consultarPasswd(usuario);

    try {
      if (usuarioConsultado.equalsIgnoreCase(usuario) && passwdConsultado.equalsIgnoreCase(hasPass)) {
        registrado = true;
        comprobar = CRUDFirebase.obtenerDatosCuenta(usuario);
        loggedInUserMail = CRUDFirebase.consultarCorreo(usuario);

        // Si coinciden los datos, inicia la vista principal de la aplicación.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalView.fxml"));
        root = loader.load();
        PrincipalController control = loader.getController();
        Scene escena = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(escena);
        control.init(stage, this, comprobar.getNombre(), root, comprobar.getTipo());
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

    } catch (NullPointerException e) {
      alertaError();
    }

  }

  // Método para volver a la pantalla previa de la aplicación.
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

  // Método para salir de la aplicación.
  @FXML
  void salir(MouseEvent event) {
    Platform.exit();
  }

  // Método que muestra la alerta de error.
  public static void alertaError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("Usuario no existe: comprueba tu usuario y tu contraseña.");
    alert.showAndWait();
  }

  // Método que muestra la alerta de error en la aplicación.
  public static void alertaFalloApp() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("App no disponible");
    alert.showAndWait();
  }

  // Método que muestra la alerta de campos vacíos.
  public static void alertaVacio() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Error");
    alert.setContentText("Campos vacíos");
    alert.showAndWait();
  }

  // Método que muestra la ubicación predeterminada.
  public static String mostrarUbicacionPredeteminada() {
    String ubicacionPredeterminada = CRUDFirebase.consultarUbicacion(comprobar.getUsuario());
    return ubicacionPredeterminada;
  }

  // Establece el escenario principal.
  public void setStage(Stage primaryStage) {
    stage = primaryStage;
  }

  // Inicializa el controlador.
  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

}
