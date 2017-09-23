package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc
import java.sql.*;

public class TestJDBC {
	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://localhost:3306/tpjava_tp1";
	static final String LOGIN = "tpjava";
	static final String PASSWORD = "tpjava";
	// La requete de test
	static final String req = "INSERT INTO ETUDIANT (NUM_ET, NOM_ET) VALUES (?,?)";

    static int[] num_etud = {5000, 5001, 5002, 5003, 5004};
    static String[] nom_etud = {"AAA", "BBB", "CCC", "DDD", "EEE"};

    public static void main(String[] args) throws SQLException {
		// Connexion a la base
		System.out.println("Connexion a " + CONNECT_URL);
		try (Connection conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD)){
			System.out.println("Connecte\n");
            PreparedStatement stmt = conn.prepareStatement(req);
            for (int i = 0; i < num_etud.length; ++i) {
                stmt.setInt(1, num_etud[i]);
                stmt.setString(2, nom_etud[i]);
                int nbTupleModifie = stmt.executeUpdate();
                System.out.println(nbTupleModifie + " tuple(s) modifié(s)");
            }
			stmt.close();
			System.out.println("\nOk.\n");
		} catch (SQLException e) {
			e.printStackTrace();// Arggg!!!
			System.out.println(e.getMessage() + "\n");
		}
	}
}
