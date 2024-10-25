module com.softwareii.appstoreit {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;
    requires java.xml.bind;


    opens com.softwareii.appstoreit to javafx.graphics;
    opens com.softwareii.appstoreit.controller to javafx.fxml;
    opens com.softwareii.appstoreit.model to java.xml.bind, java.base;
    opens com.softwareii.appstoreit.utils to java.xml.bind;



    exports com.softwareii.appstoreit;
    exports com.softwareii.appstoreit.model;
}