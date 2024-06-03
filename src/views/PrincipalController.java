package views;

import java.io.IOException;
import java.util.List;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class PrincipalController {

  // Referencia al escenario principal.
  private Stage stage;

  // Panel principal de la interfaz.
  private BorderPane borderPane;

  // Controlador del login.
  @SuppressWarnings("unused")
  private LoginController controLogin;
  
//Controlador del login.
 @SuppressWarnings("unused")
 private VerCuentaController verCuenta;

  // Controlador de la creación de cuenta.
  @SuppressWarnings("unused")
  private CrearCuentaController crearCuenta;

  // Lista de eventos.
  @SuppressWarnings("unused")
  private List<Evento> eventos;

  // Etiqueta para mostrar el nombre del usuario.
  @FXML
  private Label lblNombre;

  // Etiqueta para mostrar el tipo de cuenta del usuario.
  @FXML
  private Label lblTipoCuenta;

  // Círculo para la imagen de perfil.
  @FXML
  private Circle circulo;

  // Imagen que para mostrar una imagen.
  @FXML
  private ImageView img;

  // Botón para salir de la aplicación.
  @FXML
  private JFXButton btnSalir;

  // ComboBox para seleccionar la ubicación.
  @FXML
  private JFXComboBox<String> ubicacion;

  // Botón para ver la cuenta del usuario.
  @FXML
  private JFXButton btnVerCuenta;

  // Método para inicializar la interfaz con el controlador de login.
  void initLogin(Stage stage, LoginController loginController, String nombre, BorderPane root, String tipoCuenta)
      throws IOException {
    this.stage = stage;
    this.controLogin = loginController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = root;

    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();
  }
  
  void initVerCuenta(Stage stage, VerCuentaController verCuentaController, String nombre, BorderPane root, String tipoCuenta)
      throws IOException {
    this.stage = stage;
    this.verCuenta = verCuentaController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = root;

    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();
  }

  // Método para inicializar la interfaz con el controlador de creación de cuenta.
  void initCrearCuenta(Stage stage, CrearCuentaController crearController, String nombre, BorderPane border, String tipoCuenta)
      throws IOException {
    this.stage = stage;
    this.crearCuenta = crearController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = border;

    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();
  }

  // Método para cargar y mostrar la escena de eventos.
  public void escenaEventos() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VerEventos.fxml"));
    AnchorPane root = loader.load();
    VerEventosController verEventosController = loader.getController();

    borderPane.setCenter(root);
  }

  // Maneja el evento de clic para ver eventos.
  @FXML
  void vistaEventos(MouseEvent event) throws IOException {
    escenaEventos();
    borderPane.setLeft(null);
  }

  // Maneja el evento de clic para salir de la aplicación.
  @FXML
  void salir(MouseEvent event) throws IOException {
    escenaLogin();
  }

  // Método que cierra sesión y vuelve a mostrar el login.
  private void escenaLogin() throws IOException {
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
  
  @FXML
  void verCuenta(MouseEvent event) throws IOException {
    escenaVerCuenta();
  }
  // Método que muestra la información de la cuenta. 
  private void escenaVerCuenta() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VerCuentaView.fxml"));
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
  
 
  // Establece la lista de eventos.
  public void setEventos(List<Evento> listaEventos) {
    this.eventos = listaEventos;
  }
}
