package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import models.Evento;
import views.EventoController;

public class GridPaneEventos {
//
  public GridPane crearGridPane(int columna, int fila, List<AnchorPane> paneles) {

    GridPane nuevo = new GridPane();

    nuevo.setHgap(90);
    nuevo.setVgap(50);
    nuevo.setAlignment(Pos.CENTER);
    // Recorremos la lista de paneles
    for (AnchorPane panele : paneles) {
      nuevo.add(panele, columna, fila);
      fila++;
    }
    return nuevo;
  }

  public List<AnchorPane> crearPaneles(List<Evento> eventosList) throws IOException {
    List<AnchorPane> paneles = new ArrayList<>();

    for (int i = 0; i < eventosList.size(); i++) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/Evento.fxml"));
      AnchorPane root = loader.load();
      EventoController controlador = loader.getController();

      // Enviamos los datos de cada vehiculo al controlador de vehiculos
      controlador.setDatos(eventosList.get(i));

      // Añadimos cada panel a una lista de de AnchorPane en nuestro caso siempre de
      // root que hayamos escogido
      paneles.add(root);
    }
    return paneles;
  }

}
