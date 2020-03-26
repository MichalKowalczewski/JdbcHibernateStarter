import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxApp extends Application {

    TableView<Country> table = new TableView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        CountryDAO dao = new CountryDAO();
        ObservableList<Country> observableList = FXCollections.observableArrayList(dao.getCountries());
        table.setItems(observableList);

        TableColumn coIdCol = new TableColumn("Country Id");
        coIdCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("countryId"));
        TableColumn coNameCol = new TableColumn("Country Name");
        coNameCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("countryName"));
        TableColumn coAliasCol = new TableColumn("Country Alias");
        coAliasCol.setCellValueFactory(
                new PropertyValueFactory<Object, String>("countryAlias"));

        table.getColumns().addAll(coIdCol, coNameCol, coAliasCol);

        VBox vBox = new VBox(table);
        stage.setScene(new Scene(vBox, 800,600));
        stage.show();
    }


}