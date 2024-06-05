package application;

import java.io.IOException;
import firebase.CRUDFirebase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import views.PreviaController;

/**
 * Clase principal de la aplicación que extiende de Application. Se encarga de
 * iniciar y configurar la aplicación.
 */
public class Main extends Application {

  /**
   * Método start para iniciar la aplicación. Configura el estilo de la ventana,
   * carga la vista inicial y establece el controlador.
   *
   * @param primaryStage el escenario principal de la aplicación.
   * @throws IOException si ocurre un error durante la carga de la vista.
   */
  @Override
  public void start(Stage primaryStage) throws IOException {

    // Configurar el estilo de la ventana para eliminar los botones de minimizar,
    // maximizar y mover
    primaryStage.initStyle(StageStyle.UNDECORATED);

    // Interceptar el evento de cierre para evitar que la ventana se cierre
    primaryStage.setOnCloseRequest(event -> {
      // Consume el evento para evitar que la ventana se cierre
      event.consume();
      System.out.println("Cerrar la ventana está deshabilitado.");
    });

    // Carga la primera vista de la aplicación así como el icono de esta
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PreviaView.fxml"));
    Parent root = loader.load();
    Scene escena = new Scene(root);
    primaryStage.setScene(escena);
    PreviaController controlador = loader.getController();
    controlador.setStage(primaryStage);
    primaryStage.setMaximized(true);
    primaryStage.setResizable(false);
    primaryStage.getIcons().add(new Image("images/logo.png"));
    primaryStage.setTitle("GeoMusic");
    primaryStage.show();
    CRUDFirebase conexion = new CRUDFirebase();
  }

  /**
   * Método main para ejecutar la aplicación.
   *
   * @param args los argumentos de la línea de comandos.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
