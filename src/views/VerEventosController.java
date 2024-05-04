package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import models.Evento;
import utils.GridPaneEventos;

public class VerEventosController implements Initializable {

  private GridPaneEventos grid = new GridPaneEventos();

  static List<Evento> listaEventos = new ArrayList<>();

  static List<AnchorPane> paneles = new ArrayList<>();

  private GridPane nuevoGrid;

  private int columna = 0;
  private int fila = 0;

  // Todos los elementos
  @FXML
  private BorderPane borderPaneEventos;

  // Inicializa
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    int fila = 0;
    int columna = 0;
    try {
      // listaEventos = gestorEventos.searchAll("Evento");
      paneles = grid.crearPaneles(listaEventos);
      nuevoGrid = grid.crearGridPane(columna, fila, paneles);
      borderPaneEventos.setCenter(nuevoGrid);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
