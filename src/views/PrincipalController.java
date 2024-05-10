package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import models.Evento;

public class PrincipalController implements Initializable {

  private Stage stage;
  private BorderPane borderPane;
  @SuppressWarnings("unused")
  private LoginController controLogin;
  private CrearCuentaController crearCuenta;
  private List<Evento> eventos;

  // Todos los elementos
  @FXML
  private Label lblNombre;

  @FXML
  private Label lblTipoCuenta;

  @FXML
  private Circle circulo;

  @FXML
  private ImageView img;

  @FXML
  private JFXButton btnSalir;

  @FXML
  private JFXComboBox<String> ubicacion;

  @FXML
  private JFXButton btnVerCuenta;

  // Setea los datos necesarios y las imagenes
  void init(Stage stage, LoginController loginController, String nombre, BorderPane border, String tipoCuenta,
      String ubi) throws IOException {
    // Cargar la vista principal
    this.stage = stage;
    this.controLogin = loginController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    ubicacion.setValue(ubi);
    this.borderPane = border;

    stage.setMaximized(true);
    stage.getIcons().add(new Image("images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();

  }

  // Setea los datos necesarios y las imagenes
  void init(Stage stage, CrearCuentaController crearController, String nombre, BorderPane border, String tipoCuenta,
      String ubi) throws IOException {
    // Cargar la vista principal
    this.stage = stage;
    this.crearCuenta = crearController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    ubicacion.setValue(ubi);
    this.borderPane = border;

    stage.setMaximized(true);
    stage.getIcons().add(new Image("images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();

  }

  // Metodo que muestra la escena de inicio
  public void escenaEventos() throws IOException {
    FXMLLoader load = new FXMLLoader(getClass().getResource("/views/VerEventos.fxml"));
    AnchorPane root = load.load();
    borderPane.setCenter(root);
  }

  @FXML
  void vistaEventos(MouseEvent event) throws IOException {
    escenaEventos();
    borderPane.setLeft(null);
  }

  @FXML
  void salir(MouseEvent event) throws IOException {
    escenaLogin();
  }

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

  // Metodo que cierra sesion y vuelve a mostrar el Login
  private void escenaLogin() throws IOException {
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

  public void setEventos(List<Evento> listaEventos) {
    this.eventos = listaEventos;

  }
}
