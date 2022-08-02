# java-gradle-starter-project

This is a starter project for the usage of
- jk1 licensing plugin
- OpenApi SpringDoc generation plugin
- OpenApi generator plugin

in Gradle.

## Instructions

### IntelliJ IDEA

1. Open IntelliJ IDEA and select _File > Open..._.
2. Choose the java-gradle-starter-project directory and click _OK_.
3. Select _File > Project Structure..._ and ensure that the Project SDK and language level are set to use Java 11.
4. Open the Gradle view with _View > Tool Windows > Gradle_.
5. In the Gradle view, double-click `copyNatives` under _Tasks > build_. This will unpack the native library dependencies to $USER_HOME/.arcgis.
6. In the Gradle view, double-click `run` under _Tasks > application_ to run the app.
7. In the Gradle view, double-click `generateOpenApiDocs` to generate the OpenApi Docs in workspace `build/open-api`
8. In the Gradle view, double-click `openApiGenerate` to generate the OpenApi Docs in cwiki in workspace `build/generated`

### Command Line

1. `cd` into the project's root directory.
2. Run `./gradlew clean build` on Linux/Mac or `gradlew.bat clean build` on Windows.
3. Run `./gradlew copyNatives` on Linux/Mac or `gradlew.bat copyNatives` on Windows. This will unpack the native library dependencies to $USER_HOME.arcgis.
3. Run `./gradlew run` on Linux/Mac or `gradlew.bat run` on Windows to run the app.

## Requirements

See the Runtime SDK's [system requirements](https://developers.arcgis.com/java/reference/system-requirements/).

## Resources

* [ArcGIS Runtime SDK for Java](https://developers.arcgis.com/java/)  
* [ArcGIS Blog](https://blogs.esri.com/esri/arcgis/)  
* [Esri Twitter](https://twitter.com/esri)  

## Issues

Find a bug or want to request a new feature?  Please let us know by submitting an issue.
