package application;

import java.io.IOException;

import firebase.CRUDFirebaseCuentas;
import firebase.CRUDFirebaseEventos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import views.PreviaController;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws IOException {

    // Carga la primera vista de la aplicación así como el icono de esta
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PreviaView.fxml"));
    Parent root = loader.load();
    Scene escena = new Scene(root);
    primaryStage.setScene(escena);
    PreviaController controlador = loader.getController();
    controlador.setStage(primaryStage);
    primaryStage.setMaximized(true);
    primaryStage.getIcons().add(new Image("images/logo.png"));
    primaryStage.setTitle("GeoMusic");
    primaryStage.show();
    CRUDFirebaseCuentas conexion = new CRUDFirebaseCuentas();
  }

  // Ejecuta la función que carga la vista
  public static void main(String[] args) {
    launch(args);

  }
}
