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

  // Todos los elementos del Login
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

  void agregarProvincias() {
    // Lista de provincias de España
    List<String> provincias = new ArrayList<>();
    provincias.add("Álava");
    provincias.add("Albacete");
    provincias.add("Alicante");
    provincias.add("Almería");
    provincias.add("Asturias");
    provincias.add("Ávila");
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
    provincias.add("La Coruña");
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

    // Agrega todas las provincias al ComboBox
    ubicacion.getItems().addAll(provincias);
  }

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

        // Establece el ID del documento como el nombre de usuario
        DocumentReference docRef = firestore.collection("Cuentas").document(usuario);

        // Crea un objeto Cuenta con los datos proporcionados
        Cuenta cuenta = new Cuenta(usuario, txtNombreUser.getText(), txtUser.getText().trim(), contrasenyaHash,
            ubicacion.getValue(), txtCorreo.getText().trim(), "Normal", false);

        // Guarda el objeto Cuenta en Firestore
        WriteResult writeResult = docRef.set(cuenta).get();

        System.out.println("Cuenta añadida con ID: " + usuario);

        alertaCuentaCreada();

        // Abre la ventana PrincipalView.fxml
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
    }
  }

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

//Metodo que muestra la alerta de null
  public static void alertaVacio() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Error");
    alert.setContentText("Campos vacíos");
    alert.showAndWait();

  }

//Metodo que muestra la alerta de null
  public static void alertaNoCoinciden() {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle("Error");
    alert.setContentText("Las contraseñas no coinciden");
    alert.showAndWait();

  }

//Metodo que muestra que se ha creado la cuenta
  public static void alertaCuentaCreada() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Cuenta creada");
    alert.setContentText("A continuación vas a iniciar sesión");
    alert.showAndWait();

  }

  public void setStage(Stage primaryStage) {
    stage = primaryStage;

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // Agregar todas las provincias al ComboBox cuando se despliegue
    ubicacion.showingProperty().addListener((obs, oldValue, newValue) -> {
      if (newValue) {
        // Cuando se muestra el ComboBox, agregar todas las provincias
        agregarProvincias();
      }
    });
  }

}
