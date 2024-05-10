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
<<<<<<< HEAD

=======
//
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
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

<<<<<<< HEAD
      // Enviamos los datos de cada evento al controlador de eventos
      controlador.setDatos(eventosList.get(i));

=======
      // Enviamos los datos de cada vehiculo al controlador de vehiculos
      controlador.setDatos(eventosList.get(i));

      // Añadimos cada panel a una lista de de AnchorPane en nuestro caso siempre de
      // root que hayamos escogido
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
      paneles.add(root);
    }
    return paneles;
  }

}
