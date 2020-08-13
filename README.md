# pixel-picker
A cross-platform pixel picker.

On key press it will log the current hovered pixel. 
Clicking a cell or clicking ctrl + c will copy the value in the cell to the clipboard.

## Requirements
Have Java installed. The project has been created with [OpenJDK 14](https://jdk.java.net/14/).

## Install dependencies
`mvn install`

## Build project
`mvn compile assembly:single`

## Run project
From the root of the project:
```java -jar target/pixel-picker-1.0-SNAPSHOT-jar-with-dependencies.jar```

## Developers
The tools used to develop the application:
- Java - [OpenJDK 14](https://jdk.java.net/14/)
- [IntelliJ Community Edition](https://www.jetbrains.com/idea/)
    - Add [JavaFX](https://www.jetbrains.com/help/idea/javafx.html#add-javafx-lib)
    - Add [VM Options](https://www.jetbrains.com/help/idea/javafx.html#vm-options)
    - Add [Scene Builder](https://www.jetbrains.com/help/idea/opening-fxml-files-in-javafx-scene-builder.html#path_to_scene_builder)