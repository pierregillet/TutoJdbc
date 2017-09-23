package fr.univ_amu.iut;

import java.sql.Connection;

public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance;
    private String CONNECT_URL;

    private ConnexionUnique() {

    }

    public Connection getConnection() {
        return null;
    }

    public ConnexionUnique getInstance() {
        return null;
    }


}
