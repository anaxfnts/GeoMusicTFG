package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import firebase.CRUDFirebase;
import firebase.ConexionFirebase;
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

public class CrearCuentaController implements Initializable {

  public static BorderPane root;
  private Stage stage;

  @FXML
  private JFXTextField txtNombreUser;

  @FXML
  private JFXButton btnAtras;

  @FXML
  private JFXButton btnCancel;

  @FXML
  private JFXComboBox<String> ubicacion;

  @FXML
  private JFXTextField txtUser;

  @FXML
  private JFXButton btnCrear;

  @FXML
  private JFXTextField txtCorreo;

  @FXML
  private JFXPasswordField txtPassword;

  @FXML
  private JFXPasswordField txtPasswordComprobado;

  /**
   * Agrega una lista de provincias de España al ComboBox de ubicaciones.
   */
  void agregarProvincias() {
    List<String> provincias = new ArrayList<>();
    provincias.add("Alava");
    provincias.add("Albacete");
    provincias.add("Alicante");
    provincias.add("Almería");
    provincias.add("Asturias");
    provincias.add("Avila");
    provincias.add("Badajoz");
    provincias.add("Barcelona");
    provincias.add("Burgos");
    provincias.add("Cáceres");
    provincias.add("Cádiz");
    provincias.add("Cantabria");
    provincias.add("Castellón");
    provincias.add("Ciudad Real");
    provincias.add("Córdoba");
    provincias.add("Cuenca");
    provincias.add("Gerona");
    provincias.add("Granada");
    provincias.add("Guadalajara");
    provincias.add("Guipúzcoa");
    provincias.add("Huelva");
    provincias.add("Huesca");
    provincias.add("Islas Baleares");
    provincias.add("Jaén");
    provincias.add("La Corunya");
    provincias.add("La Rioja");
    provincias.add("Las Palmas");
    provincias.add("León");
    provincias.add("Lérida");
    provincias.add("Lugo");
    provincias.add("Madrid");
    provincias.add("Málaga");
    provincias.add("Murcia");
    provincias.add("Navarra");
    provincias.add("Orense");
    provincias.add("Palencia");
    provincias.add("Pontevedra");
    provincias.add("Salamanca");
    provincias.add("Segovia");
    provincias.add("Sevilla");
    provincias.add("Soria");
    provincias.add("Tarragona");
    provincias.add("Santa Cruz de Tenerife");
    provincias.add("Teruel");
    provincias.add("Toledo");
    provincias.add("Valencia");
    provincias.add("Valladolid");
    provincias.add("Vizcaya");
    provincias.add("Zamora");
    provincias.add("Zaragoza");

    ubicacion.getItems().clear();
    ubicacion.getItems().addAll(provincias);
  }

  /**
   * Crea una cuenta nueva y la guarda en Firestore.
   *
   * @param event El evento de ratón que dispara el método.
   * @throws IOException          Si ocurre un error de E/S.
   * @throws InterruptedException Si ocurre una interrupción durante la operación.
   * @throws ExecutionException   Si ocurre un error en la ejecución.
   */
  @FXML
  void crearCuenta(MouseEvent event) throws IOException, InterruptedException, ExecutionException {
    String usuario = txtUser.getText();
    String usuarioConsultado = CRUDFirebase.consultarUsuario(usuario);
    String contrasenyaHash = HashPassword.convertirSHA256(txtPassword.getText());

    if (usuario.isEmpty()) {
      alertaVacio();
    } else if (!txtPassword.getText().equals(txtPasswordComprobado.getText())) {
      alertaNoCoinciden();
    } else {
      if (usuarioConsultado.equalsIgnoreCase(usuario)) {
        Firestore firestore = ConexionFirebase.getFirestore();
        DocumentReference docRef = firestore.collection("Cuentas").document(usuario);

        Cuenta cuenta = new Cuenta(usuario, txtNombreUser.getText(), txtUser.getText().trim(), contrasenyaHash,
            ubicacion.getValue(), txtCorreo.getText().trim(), "Normal", false);

        @SuppressWarnings("unused")
        WriteResult writeResult = docRef.set(cuenta).get();

        System.out.println("Cuenta anyadida con ID: " + usuario);

        alertaCuentaCreada();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PreviaView.fxml"));
        AnchorPane root = loader.load();
        Scene escena = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(escena);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.getIcons().add(new Image("images/logo.png"));
        stage.show();
        if (this.stage != null) {
          this.stage.close();
        }
      }
    }
  }

  /**
   * Regresa a la vista anterior.
   *
   * @param event El evento de ratón que dispara el método.
   * @throws IOException Si ocurre un error de E/S.
   */
  @FXML
  void atras(MouseEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PreviaView.fxml"));
    AnchorPane root = loader.load();
    Scene escena = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(escena);
    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("images/logo.png"));
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
   * Muestra una alerta de error.
   */
  public static void alertaError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("Usuario incorrecto");
    alert.showAndWait();
  }

  /**
   * Muestra una alerta indicando que hay campos vacíos.
   */
  public static void alertaVacio() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Error");
    alert.setContentText("Campos vacíos");
    alert.showAndWait();
  }

  /**
   * Muestra una alerta indicando que las contraseñas no coinciden.
   */
  public static void alertaNoCoinciden() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Error");
    alert.setContentText("Las contrasenyas no coinciden");
    alert.showAndWait();
  }

  /**
   * Muestra una alerta indicando que la cuenta ha sido creada.
   */
  public static void alertaCuentaCreada() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Cuenta creada");
    alert.setContentText("A continuación vas a iniciar sesión");
    alert.showAndWait();
  }

  /**
   * Establece la instancia de Stage para el controlador.
   *
   * @param primaryStage La instancia de Stage principal.
   */
  public void setStage(Stage primaryStage) {
    stage = primaryStage;
  }

  /**
   * Inicializa el controlador.
   *
   * @param location  La ubicación utilizada para resolver rutas relativas del
   *                  objeto raíz, o null si no se conoce.
   * @param resources Los recursos utilizados para localizar el objeto raíz, o
   *                  null si no se conocen.
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ubicacion.showingProperty().addListener((obs, oldValue, newValue) -> {
      if (newValue) {
        agregarProvincias();
      }
    });
  }

}
