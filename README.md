# Pixel Picker
A cross-platform pixel picker tool. It will enable users to record keys and pixel information.

On key press it will log the current hovered pixel into a table. 
Clicking a cell will copy the value of the cell to the clipboard.

## Requirements
Have Java installed.
To automatically configure Java, download and install [AdoptOpenJDK Prebuilt OpenJDK](https://adoptopenjdk.net/).

## Usage
Java has to be installed (see Requirements)!
- Download the [latest release](https://github.com/bartduisters/pixel-picker/releases/)
- Linux: Download the .jar, in the terminal type in `java -jar pixel-picker.jar` and press enter
- Mac: Download the .jar, double click `pixel-picker.jar`
    - New versions might need to give Java permissions for accessibility and screen recording
    - If double clicking does not work, open a terminal and type in `java -jar pixel-picker.jar` and press enter
- Windows: Download the .jar, double click `pixel-picker.jar`

![](https://bartduisters.com/products/pixel-picker/1-0-0/pixel-picker-example.png)
![](https://bartduisters.com/products/pixel-picker/1-0-0/pixel-picker-example-mac.png)
![](https://bartduisters.com/products/pixel-picker/1-0-0/pixel-picker-example-win.png)

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
- Java - [OpenJDK 14](https://jdk.java.net/14/) - prebuilt binaries can be downloaded from [AdoptOpenJDK Prebuilt OpenJDK](https://adoptopenjdk.net/)
- [IntelliJ Community Edition](https://www.jetbrains.com/idea/)
    - Add [JavaFX](https://www.jetbrains.com/help/idea/javafx.html#add-javafx-lib)
    - Add [VM Options](https://www.jetbrains.com/help/idea/javafx.html#vm-options)
    - Add [Scene Builder](https://www.jetbrains.com/help/idea/opening-fxml-files-in-javafx-scene-builder.html#path_to_scene_builder)
    
