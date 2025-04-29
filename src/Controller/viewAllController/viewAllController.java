package Controller.viewAllController;

import Db.dbItemManagementForm;
import Model.itemManagementModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import Controller.itemManagementController;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class viewAllController implements Initializable {


    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDescription;
    public TableView grid;

    private ArrayList<itemManagementModel> list = dbItemManagementForm.getInstance();



        itemManagementController itemManagementController = new itemManagementController();




    public void btnReloanOnAction(ActionEvent actionEvent) {

        loadTable();
    }


    private void loadTable(){


        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        ObservableList<itemManagementModel> obList = FXCollections.observableArrayList();

        list.forEach(listEach ->{

            obList.add(listEach);

        });

        grid.setItems(obList);


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTable();
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {

        itemManagementModel selectedItem = (itemManagementModel) grid.getSelectionModel().getSelectedItem();

        list.remove(selectedItem);

        loadTable();



    }
}
