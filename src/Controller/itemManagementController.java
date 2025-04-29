package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import Model.itemManagementModel;
import  Db.dbItemManagementForm;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class itemManagementController {


    public Label lblId;
    public TextField txtName;
    public TextField txtQty;
    public TextField txtPrice;
    public TextField txtItemDescription;
    
    public TableColumn colItemCode;
    public TableColumn colName;
    public TableColumn colQty;
    public TableColumn colPrice;
    public TableColumn colDescription;
    public TableView grid;

    ArrayList<itemManagementModel> list = dbItemManagementForm.getInstance();

        public void btnAddOnClick(ActionEvent actionEvent) {

            add();



    }

    private void add(){

        int qty = 0;
        double price = 0;

        try {
             qty = Integer.parseInt(txtQty.getText());
        } catch (NumberFormatException e) {

            txtQty.setText("");
            txtQty.setPromptText("Invalid No");
            return;
        }

        try {
            price = Double.parseDouble(txtPrice.getText());
        } catch (NumberFormatException e) {
            txtPrice.setText("");
            txtPrice.setPromptText("Invalid No");
            return;
        }


            list.add(new itemManagementModel(list.size()+"",txtName.getText(),qty,Double.parseDouble(txtPrice.getText()),txtItemDescription.getText()));

            loadTable();


}

    public  void loadTable(){

        colItemCode.setCellValueFactory(new PropertyValueFactory<>("id"));
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


    public void btnViewAllOnClick(ActionEvent actionEvent) throws IOException {


            Stage stage = new Stage();
        stage.setScene(
                new Scene(
                        FXMLLoader.load(
                                getClass().getResource("/View/viewAll/viewAll.fxml")
                        )
                )
        );
        stage.show();

        }

}
