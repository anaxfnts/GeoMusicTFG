package views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class EventosController {

  @FXML
  private Pane paneEventos;

  @FXML
  void vistaEventos(MouseEvent event) throws IOException {
    vistaVerEventos();

  }

  private void vistaVerEventos() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalView.fxml"));
    AnchorPane root = loader.load();
    LoginController.root.setCenter(root);

  }


}
