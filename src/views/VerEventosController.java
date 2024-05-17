package views;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import firebase.CRUDFirebase;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import models.Evento;
import utils.GridPaneEventos;

public class VerEventosController implements Initializable {
  private GridPaneEventos grid = new GridPaneEventos();
  private static List<Evento> listaEventos = new ArrayList<>();
  private static List<AnchorPane> paneles = new ArrayList<>();
  private GridPane nuevoGrid;
  private String ubicacionSeleccionada;
  private String ubicacionPredeterminada;


  @FXML
  private BorderPane borderPaneEventos;
  
  @FXML
  private JFXComboBox<String> ubicacion;


  @Override
  public void initialize(URL location, ResourceBundle resources) {
      int fila = 0;
      int columna = 0;

      ubicacion.valueProperty().addListener(new ChangeListener<String>() {
          @Override
          public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              try {
                  actualizarSegunUbicacion(newValue);
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      });
      
      // Agregar todas las provincias al ComboBox cuando se despliegue
      ubicacion.showingProperty().addListener((obs, oldValue, newValue) -> {
          if (newValue) {
              // Cuando se muestra el ComboBox, agregar todas las provincias
              agregarProvincias();
          }
      });

      try {
          ubicacionPredeterminada = LoginController.mostrarUbicacionPredeteminada();
          ubicacion.setValue(ubicacionPredeterminada);
          listaEventos = CRUDFirebase.consultarEventos(ubicacionPredeterminada);
          paneles = grid.crearPaneles(listaEventos);
          nuevoGrid = grid.crearGridPane(columna, fila, paneles);
          borderPaneEventos.setCenter(nuevoGrid);
      } catch (IOException e) {
          e.printStackTrace();
      }
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

  private static void limpiarListas() {
    listaEventos.clear();
    paneles.clear();
  }

  // Método para devolver la lista de eventos
  public List<Evento> getListaEventos() {
    return listaEventos;
  }

  public void actualizarSegunUbicacion(String ubicacionSeleccionada) throws IOException {
    try {
        limpiarListas();
        // Consultar eventos según la ubicación seleccionada
        listaEventos = CRUDFirebase.consultarEventos(ubicacionSeleccionada);

        // Limpiar el GridPane y la lista de paneles
        borderPaneEventos.getChildren().clear();
        paneles.clear();

        // Crear los nuevos paneles para los eventos filtrados
        paneles = grid.crearPaneles(listaEventos);

        // Crear el nuevo GridPane y establecerlo en el BorderPane
        nuevoGrid = grid.crearGridPane(0, 0, paneles);
        borderPaneEventos.setCenter(nuevoGrid);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  
}
