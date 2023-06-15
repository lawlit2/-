package com.example.lagfx;

import com.example.lagfx.LinkDatabase.LinkAndSelect;
import com.example.lagfx.Util.MathTool;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.List;

public class LagController {
    @FXML
    public TextField y;
    @FXML
    public TextField x;
    @FXML
    public Button button;

    @FXML
    public void MathmaticlAction(javafx.event.ActionEvent actionEvent) {
        double x0;
        double y0;
        String y1;
        x0 = Double.parseDouble(x.getText());
        MathTool mathTool = new MathTool();
        LinkAndSelect linkAndSelect = new LinkAndSelect();
        List<Double> value = linkAndSelect.GetData();
        List<Double> fun = linkAndSelect.GetFunction();
        y0 = mathTool.LinearInterpolation(value,fun,x0);
        y1 = String.valueOf(y0);
        linkAndSelect.insertXY(x0,y0);
        y.setText(y1);


    }
    @FXML
    private javafx.scene.control.TableView<ValueAndFun> TableView;

    @FXML
    private TableColumn<ValueAndFun, Double> X;

    @FXML
    private TableColumn<ValueAndFun, Double> Y;

    public void initialize(){
        LinkAndSelect linkAndSelect = new LinkAndSelect();
        List<ValueAndFun> rdd = linkAndSelect.GetFunctionAndValue();
        ObservableList<ValueAndFun> celldate = FXCollections.observableArrayList();
        X.setCellValueFactory(new PropertyValueFactory<ValueAndFun,Double>("X"));
        Y.setCellValueFactory(new PropertyValueFactory<ValueAndFun,Double>("Y"));
        celldate.addAll(rdd);
        List<ValueAndFun> table = linkAndSelect.GetFunctionAndValue();
       TableView.setItems(celldate);
    }
}