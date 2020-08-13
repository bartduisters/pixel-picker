package com.bartduisters.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataRow {
    SimpleIntegerProperty index;
    SimpleStringProperty color;
    SimpleIntegerProperty x;
    SimpleIntegerProperty y;

    public DataRow(int index, String color, Integer x, Integer y) {
        this.index = new SimpleIntegerProperty(index);
        this.color = new SimpleStringProperty(color);
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public int getIndex() {
        return this.index.get();
    }

    public void setIndex(int index) {
        this.index.set(index);
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public int getX() {
        return x.get();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public int getY() {
        return y.get();
    }

    public void setY(int y) {
        this.y.set(y);
    }
}