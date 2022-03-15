import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "a1nesxdf8870";

        final String SQL_QUERY_AVG = "SELECT PurchaseList.course_name, Grp.count AS purchase_count, " +
                "Grp.min_date AS first_purchase_date, Grp.max_date AS last_purchase_date, " +
                "Grp.count / (MONTH (Grp.max_date) - MONTH (Grp.min_date) + 1) AS period_avg_purchases_count, " +
                "Grp.count / (12 - MONTH (Grp.min_date) + 1) AS year_avg_purchases_count " +
                "FROM PurchaseList JOIN(SELECT course_name, " +
                "MIN(subscription_date) min_date, MAX(subscription_date) max_date, COUNT(*) count " +
                "FROM PurchaseList GROUP BY course_name) Grp " +
                "ON PurchaseList.course_name = Grp.course_name AND PurchaseList.subscription_date = Grp.max_date " +
                "ORDER BY course_name;";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();

            getAvgPurchases(statement, SQL_QUERY_AVG);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getAvgPurchases(Statement statement, String SQL_QUERY_AVG) throws SQLException {
        ResultSet resultSetAvg = statement.executeQuery(SQL_QUERY_AVG);
        while (resultSetAvg.next()) {
            System.out.println(resultSetAvg.getString("course_name") + " = " + resultSetAvg.getString("year_avg_purchases_count"));
        }
        resultSetAvg.close();
    }
}
