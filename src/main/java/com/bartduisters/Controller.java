package com.bartduisters;

import com.bartduisters.models.DataRow;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.robot.Robot;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    int i = 0;
    @FXML
    private Circle colorCircle;
    @FXML
    private Label colorText;
    @FXML
    private Label coordinatesText;
    @FXML
    private TableView<DataRow> pixelTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Robot robot = new Robot();
        createTable();
        final Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(100),
                        event -> {
                            int x = (int) robot.getMouseX();
                            int y = (int) robot.getMouseY();
                            Color color = robot.getPixelColor(x, y);
                            colorCircle.setFill(color);
                            String colorString = "#" + color.toString().substring(2, 8);
                            colorText.setText(colorString);
                            coordinatesText.setText("x: " + x + "y: " + y);
                            if (i < 101) {
                                DataRow entry = new DataRow(i, colorString, x, y);
                                pixelTable.getItems().add(entry);
                            }
                            i++;
                        }
                )
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void createTable() {
        TableColumn indexCol = new TableColumn("#");
        indexCol.setCellValueFactory(new PropertyValueFactory<>("index"));
        indexCol.setPrefWidth(35d);

        TableColumn colorCol = new TableColumn("Color");
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));

        TableColumn xCol = new TableColumn("X");
        xCol.setCellValueFactory(new PropertyValueFactory<>("x"));

        TableColumn yCol = new TableColumn("Y");
        yCol.setCellValueFactory(new PropertyValueFactory<>("y"));

        pixelTable.getColumns().clear();
        pixelTable.getColumns().addAll(indexCol, colorCol, xCol, yCol);

        pixelTable.getSelectionModel().setCellSelectionEnabled(true);
        pixelTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        pixelTable.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                copySelectedCellToClipboard();
            }
        });

        pixelTable.setOnKeyPressed(keyEvent -> {
            if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.C) {
                copySelectedCellToClipboard();
            }
        });

    }

    private void copySelectedCellToClipboard() {
        int colIndex = pixelTable.getFocusModel().getFocusedCell().getColumn();
        DataRow selectionModel = pixelTable.getSelectionModel().getSelectedItem();
        String contentString = "";
        if (colIndex == 1) {
            contentString = selectionModel.getColor();
        }
        if (colIndex == 2) {
            contentString = String.valueOf(selectionModel.getX());
        }
        if (colIndex == 3) {
            contentString = String.valueOf(selectionModel.getY());
        }
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(contentString);
        clipboard.setContent(content);
    }

}
