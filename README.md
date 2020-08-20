# Pixel Picker
A cross-platform pixel picker tool. It will enable users to record keys and pixel information.

On key press it will log the current hovered pixel into a table. 
Clicking a cell copy the value in the cell to the clipboard.

![](https://bartduisters.com/products/pixel-picker/1-0-0/pixel-picker-example.png)

## Requirements
Have Java installed. The project has been created with [OpenJDK 14](https://jdk.java.net/14/).

To automatically configure Java, download and install [AdoptOpenJDK Prebuilt OpenJDK](https://adoptopenjdk.net/)

## Usage
Java has to be installed (see Requirements)!
- Download the [latest release](https://github.com/bartduisters/pixel-picker/releases/) (.jar)
- Open command prompt/terminal and navigate to the directory containing the .jar
- In the command prompt/terminal type in `java -jar pixe-picker.jar` and press Enter

# Developers
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
    
