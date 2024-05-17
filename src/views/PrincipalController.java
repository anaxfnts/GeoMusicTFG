package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import firebase.CRUDFirebase;
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

public class PrincipalController {

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
  void init(Stage stage, LoginController loginController, String nombre, BorderPane border, String tipoCuenta) throws IOException {
    // Cargar la vista principal
    this.stage = stage;
    this.controLogin = loginController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = border;
   
    stage.setMaximized(true);
    stage.getIcons().add(new Image("images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();

  }

  // Setea los datos necesarios y las imagenes
  void init(Stage stage, CrearCuentaController crearController, String nombre, BorderPane border, String tipoCuenta) throws IOException {
    // Cargar la vista principal
    this.stage = stage;
    this.crearCuenta = crearController;
    lblNombre.setText(nombre);
    lblTipoCuenta.setText(tipoCuenta);
    this.borderPane = border;

    stage.setMaximized(true);
    stage.getIcons().add(new Image("images/logo.PNG"));
    stage.setTitle("GeoMusic");

    stage.show();
    escenaEventos();

  }

  public void escenaEventos() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VerEventos.fxml"));
    AnchorPane root = loader.load();
    VerEventosController verEventosController = loader.getController();

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

  

  public void setEventos(List<Evento> listaEventos) {
    this.eventos = listaEventos;

  }
}
