package views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class EventosController {

  // Referencia al panel de eventos.
  @FXML
  private Pane paneEventos;

  // Método para cambiar a la vista de eventos.
  @FXML
  void vistaEventos(MouseEvent event) throws IOException {
    vistaVerEventos();
  }

  // Método para cargar la vista de eventos.
  private void vistaVerEventos() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalView.fxml"));
    AnchorPane root = loader.load();
    // Se establece la vista de eventos en el centro del panel raíz.
    LoginController.root.setCenter(root);
  }
}
