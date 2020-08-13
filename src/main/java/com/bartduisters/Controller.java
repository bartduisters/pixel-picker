package com.bartduisters;

import com.bartduisters.models.DataRow;
import com.bartduisters.services.JavaFxDispatchService;
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
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable, NativeKeyListener {
    private final Robot robot = new Robot();
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
        System.out.println("Initialize");
        registerNativeHook();
        createTable();
        final Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(100),
                        event -> {
                            colorCircle.setFill(getColor());
                            colorText.setText(getColorString());
                            coordinatesText.setText("x: " + getX() + "y: " + getY());
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

        TableColumn keyCol = new TableColumn("Key");
        keyCol.setCellValueFactory(new PropertyValueFactory<>("key"));

        pixelTable.getColumns().clear();
        pixelTable.getColumns().addAll(indexCol, colorCol, xCol, yCol, keyCol);

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

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        i++;
        DataRow entry = new DataRow(i, getColorString(), getX(), getY(), NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
        pixelTable.getItems().add(entry);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    private void registerNativeHook() {
        GlobalScreen.setEventDispatcher(new JavaFxDispatchService());

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(this);

        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
    }

    private int getX() {
        return (int) robot.getMouseX();
    }

    private int getY() {
        return (int) robot.getMouseY();
    }

    private Color getColor() {
        return robot.getPixelColor(getX(), getY());
    }

    private String getColorString() {
        return "#" + getColor().toString().substring(2, 8);
    }
}
