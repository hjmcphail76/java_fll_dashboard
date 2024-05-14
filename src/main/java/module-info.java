module com.java_fll_dashboard {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.java_fll_dashboard to javafx.fxml;
    exports com.java_fll_dashboard;
}
