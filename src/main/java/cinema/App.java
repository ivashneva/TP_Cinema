package cinema;

import cinema.view.MainView;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        MainView.getInstance().runMainView();
    }
}
