module com.java_fll_dashboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires volctl;
    requires jdk.xml.dom;

    opens com.java_fll_dashboard to javafx.fxml;
    exports com.java_fll_dashboard;
}
