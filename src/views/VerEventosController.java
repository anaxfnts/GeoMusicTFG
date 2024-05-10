package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

<<<<<<< HEAD
import firebase.CRUDFirebaseEventos;
=======
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import models.Evento;
import utils.GridPaneEventos;

public class VerEventosController implements Initializable {
<<<<<<< HEAD
  private GridPaneEventos grid = new GridPaneEventos();
  private static List<Evento> listaEventos = new ArrayList<>();
  private static List<AnchorPane> paneles = new ArrayList<>();
  private GridPane nuevoGrid;

  @FXML
  private BorderPane borderPaneEventos;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    int fila = 0;
    int columna = 0;
    try {
      Evento evento1 = new Evento("eventoEjemplo", "Duki", "Madrid", "08-06-2024", "dukiBernabeu.jpg", "descripcion");
      Evento evento2 = new Evento("eventoEjemplo", "Duki", "Madrid", "08-06-2024", "dukiBernabeu.jpg", "descripcion");
      listaEventos.add(evento1);
      listaEventos.add(evento2);
      //listaEventos = CRUDFirebaseEventos.consultarEventos();
      paneles = grid.crearPaneles(listaEventos);
      nuevoGrid = grid.crearGridPane(columna, fila, paneles);
      borderPaneEventos.setCenter(nuevoGrid);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void limpiarListas() {
    listaEventos.clear();
    paneles.clear();
  }

  // Método para devolver la lista de eventos
  public List<Evento> getListaEventos() {
    return listaEventos;
  }
=======

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

>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
}
