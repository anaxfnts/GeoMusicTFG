package views;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.Evento;

public class PrincipalController {

  // Referencia al escenario principal.
  private Stage stage;

  // Panel principal de la interfaz.
  private BorderPane borderPane;

  // Controlador del login.
  @SuppressWarnings("unused")
  private LoginController controLogin;

  // Controlador del login.
  @SuppressWarnings("unused")
  private VerCuentaController verCuenta;

  // Controlador de la creación de cuenta.
  @SuppressWarnings("unused")
  private CrearCuentaController crearCuenta;

  @SuppressWarnings("unused")
  private EditarCuentaController editarCuenta;

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
  private Button btnSalir;

  // ComboBox para seleccionar la ubicación.
  @FXML
  private ComboBox<String> ubicacion;

  // Botón para ver la cuenta del usuario.
  @FXML
  private Button btnVerCuenta;

  /**
   * Inicializa la interfaz con el controlador de login.
   *
   * @param stage           El escenario principal de la aplicación.
   * @param loginController El controlador del login.
   * @param nombre          El nombre del usuario.
   * @param root            El panel principal de la interfaz.
   * @param tipoCuenta      El tipo de cuenta del usuario.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  void initLogin(Stage stage, LoginController loginController, String nombre, BorderPane root, String tipoCuenta)
      throws IOException {
    this.stage = stage;
    this.controLogin = loginController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = root;

    stage.initStyle(StageStyle.UNDECORATED); // Quita la barra de título
    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("/images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();
  }

  /**
   * Inicializa la interfaz con el controlador de ver cuenta.
   *
   * @param stage               El escenario principal de la aplicación.
   * @param verCuentaController El controlador de ver cuenta.
   * @param nombre              El nombre del usuario.
   * @param root                El panel principal de la interfaz.
   * @param tipoCuenta          El tipo de cuenta del usuario.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  void initVerCuenta(Stage stage, VerCuentaController verCuentaController, String nombre, BorderPane root,
      String tipoCuenta) throws IOException {
    this.stage = stage;
    this.verCuenta = verCuentaController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = root;

    stage.initStyle(StageStyle.UNDECORATED); // Quita la barra de título
    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("/images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();
  }

  /**
   * Inicializa la interfaz con el controlador de editar cuenta.
   *
   * @param stage                  El escenario principal de la aplicación.
   * @param editarCuentaController El controlador de editar cuenta.
   * @param nombre                 El nombre del usuario.
   * @param root                   El panel principal de la interfaz.
   * @param tipoCuenta             El tipo de cuenta del usuario.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  void initEditarCuenta(Stage stage, EditarCuentaController editarCuentaController, String nombre, BorderPane root,
      String tipoCuenta) throws IOException {
    this.stage = stage;
    this.editarCuenta = editarCuentaController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = root;

    stage.initStyle(StageStyle.UNDECORATED); // Quita la barra de título
    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("/images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();
  }

  /**
   * Inicializa la interfaz con el controlador de creación de cuenta.
   *
   * @param stage           El escenario principal de la aplicación.
   * @param crearController El controlador de creación de cuenta.
   * @param nombre          El nombre del usuario.
   * @param border          El panel principal de la interfaz.
   * @param tipoCuenta      El tipo de cuenta del usuario.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  void initCrearCuenta(Stage stage, CrearCuentaController crearController, String nombre, BorderPane border,
      String tipoCuenta) throws IOException {
    this.stage = stage;
    this.crearCuenta = crearController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = border;

    stage.initStyle(StageStyle.UNDECORATED); // Quita la barra de título
    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("/images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();
  }

  /**
   * Carga y muestra la escena de eventos.
   *
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  public void escenaEventos() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VerEventos.fxml"));
    AnchorPane root = loader.load();
    VerEventosController verEventosController = loader.getController();

    borderPane.setCenter(root);
  }

  /**
   * Maneja el evento de clic para ver eventos.
   *
   * @param event El evento de ratón que dispara el método.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  @FXML
  void vistaEventos(MouseEvent event) throws IOException {
    escenaEventos();
    borderPane.setLeft(null);
  }

  /**
   * Maneja el evento de clic para salir de la aplicación.
   *
   * @param event El evento de ratón que dispara el método.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  @FXML
  void salir(MouseEvent event) throws IOException {
    escenaLogin();
  }

  /**
   * Cierra sesión y vuelve a mostrar el login.
   *
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  private void escenaLogin() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PreviaView.fxml"));
    AnchorPane root = loader.load();
    Scene escena = new Scene(root);
    Stage stage = new Stage();
    stage.initStyle(StageStyle.UNDECORATED); // Quita la barra de título
    stage.setScene(escena);
    stage.setMaximized(true);
    stage.setResizable(false);
    stage.getIcons().add(new Image("/images/logo.png"));
    stage.show();
    if (this.stage != null) {
      this.stage.close();
    }
  }

  /**
   * Maneja el evento de clic para ver la cuenta del usuario.
   *
   * @param event El evento de ratón que dispara el método.
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  @FXML
  void verCuenta(MouseEvent event) throws IOException {
    escenaVerCuenta();
  }

  /**
   * Carga y muestra la escena de ver cuenta.
   *
   * @throws IOException Si ocurre un error de E/S al cargar la vista.
   */
  private void escenaVerCuenta() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VerCuentaView.fxml"));
    BorderPane verCuentaView = loader.load();
    // Se obtiene la escena actual del stage y se establece el nuevo contenido
    Scene escena = stage.getScene();
    BorderPane root = (BorderPane) escena.getRoot();
    root.getChildren().clear();
    root.getChildren().add(verCuentaView);
  }

  /**
   * Establece el escenario principal.
   *
   * @param primaryStage El escenario principal de la aplicación.
   */
  public void setStage(Stage primaryStage) {
    stage = primaryStage;
  }

  /**
   * Establece la lista de eventos.
   *
   * @param listaEventos La lista de eventos.
   */
  public void setEventos(List<Evento> listaEventos) {
    this.eventos = listaEventos;
  }
}
