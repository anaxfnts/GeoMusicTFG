package views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class VerCuentaController {

    private BorderPane borderPane;

    @FXML
    private JFXTextField txtNombreUser;

    @FXML
    private JFXButton btnAtras;

    @FXML
    private JFXButton btnCancel;

    @FXML
    private JFXComboBox<String> ubicacion;

    @FXML
    private JFXTextField txtUser;

    @FXML
    private JFXButton btnCrear;

    @FXML
    private JFXTextField txtCorreo;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtPasswordComprobado;

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
        // Agrega todas las provincias al ComboBox
        ubicacion.getItems().addAll(provincias);
    }

    @FXML
    void atras(MouseEvent event) throws IOException {
        // Carga la vista principal desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrincipalView.fxml"));
        BorderPane root = loader.load();

        // Obtén el controlador de la vista principal si necesitas realizar acciones específicas
        PrincipalController principalController = loader.getController();

        // Configura la escena actual para usar la nueva raíz cargada
        Scene escenaActual = btnAtras.getScene();
        BorderPane rootActual = (BorderPane) escenaActual.getRoot();

        // Cambia el centro del BorderPane actual
        rootActual.setCenter(root);

        // Llama a los métodos necesarios en el controlador de la vista principal
        principalController.cargarVistaCuenta();
        principalController.cargarVistaEventos();
    }

    // Método para cargar y mostrar la escena de eventos.
    public void escenaEventos() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/VerEventos.fxml"));
        AnchorPane root = loader.load();
        VerEventosController verEventosController = loader.getController();

        // Asegúrate de que `borderPane` esté inicializado y sea la raíz de la escena actual
        borderPane.setCenter(root);
    }

    // Maneja el evento de clic para ver eventos.
    @FXML
    void vistaEventos(MouseEvent event) throws IOException {
        escenaEventos();
        borderPane.setLeft(null);
    }
}
