import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class MainDB {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    public static void main(String[] args) {
        try {
            connect();
            //Создать таблицу
            //createTable();

            //Выборка из таблицы
            //selectTable();

            //Очистка таблицы
            //clearTable();

            //Удаление строки
            //deletePositionTable();

            //удаляем таблицу
            //dropTable();

            //читаем файл и обновляем из файла
            //readFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            disconnect();
        }

    }
    public static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createTable() throws SQLException {

        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS newTable (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "cost INTEGER" +
                ")");
    }
    private static void dropTable() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS newTable;");
    }
    private static void insertTable() throws SQLException {
        connection.setAutoCommit(false);
        psInsert = connection.prepareStatement("INSERT INTO newTable (title, cost) VALUES (?, ?);");
        for (int i = 0; i < 4; i++) {
            psInsert.setString(1, "bob"+(i+1));
            psInsert.setInt(2, 10 + (i * 10));
            psInsert.addBatch();
        }
        psInsert.executeBatch();
        connection.setAutoCommit(true);
    }
    private static void selectTable() throws SQLException {
        System.out.println("Ввести имя (bob1, bob2, bob3)");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        String sql = String.format("SELECT cost FROM newTable where title = '%s';", res);
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            System.out.println(rs.getString("cost"));
        } else {
            System.out.println("Такой записи нет");
        }
    }
    private static void clearTable() throws SQLException {
        stmt.executeUpdate("DELETE FROM newTable;");
    }
    private static void deletePositionTable() throws SQLException {
        System.out.println("Ввести имя записи для удаления (bob1, bob2, bob3)");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String sql = String.format("DELETE FROM newTable WHERE title = '%s';",title);
        stmt.executeUpdate(sql);
    }
    public static void readFile() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("text.txt");
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            String[] mass = scanner.nextLine().split(" ");
            try {
                updateDB(mass[0], mass[1], mass[2]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void updateDB(String id, String title, String value) throws SQLException {
        String sql = String.format("UPDATE newTable SET cost = '%s', title = '%s' WHERE id = '%s'", value, title, id);
        stmt.executeUpdate(sql);
    }
}
