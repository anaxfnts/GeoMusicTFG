package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CrearCuentaController implements Initializable {

    public static BorderPane root;
    private Stage stage;

    // Todos los elementos del Login
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnAtras;

    @FXML
    private TextField txtNombreUser;

    @FXML
    private TextField txtCorreo;

    @FXML
    private ComboBox<String> ubicacion;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUser;

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

      // Agregar todas las provincias al ComboBox
      ubicacion.getItems().addAll(provincias);
  }


     @FXML
     void crearCuenta(MouseEvent event) throws IOException {
       //Hacer consulta que compruebe que en documento el nombre sea unico para usuario
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalView.fxml"));
       AnchorPane root = loader.load();
       Scene escena = new Scene(root);
       Stage stage = new Stage();
       stage.setScene(escena);
       stage.show();
       if (this.stage != null) {
         this.stage.close();
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
