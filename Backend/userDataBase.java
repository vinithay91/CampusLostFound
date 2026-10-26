import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDataBase {

    // REGISTER USER
    public static void addUser(
        String name,
        String email,
        String password,
        String phone
    ) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "INSERT INTO users (name, email, password, phone) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, phone);

            ps.executeUpdate();

            System.out.println("User added successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // GET USERS
    public static String getUsers() {

        StringBuilder users = new StringBuilder();

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT user_id, name, email, phone FROM users";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (users.length() > 0) {
                    users.append(",");
                }

                users.append("{");

                users.append("\"user_id\":")
                     .append(rs.getInt("user_id"))
                     .append(",");

                users.append("\"name\":\"")
                     .append(rs.getString("name"))
                     .append("\",");

                users.append("\"email\":\"")
                     .append(rs.getString("email"))
                     .append("\",");

                users.append("\"phone\":\"")
                     .append(rs.getString("phone"))
                     .append("\"");

                users.append("}");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "[" + users.toString() + "]";
    }


    // LOGIN
    public static boolean loginUser(
        String email,
        String password
    ) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT * FROM users WHERE email = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }


    // ADD LOST ITEM
    public static void addLostItem(
        String itemName,
        String description,
        String category,
        String location,
        String dateLost,
        String contact
    ) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "INSERT INTO lost_items " +
                "(item_name, description, category, location, date_lost, contact) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, itemName);
            ps.setString(2, description);
            ps.setString(3, category);
            ps.setString(4, location);
            ps.setString(5, dateLost);
            ps.setString(6, contact);

            ps.executeUpdate();

            System.out.println("Lost item added successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // GET LOST ITEMS
    public static String getLostItems() {

        StringBuilder items = new StringBuilder();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM lost_items";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (items.length() > 0) {
                    items.append(",");
                }

                items.append("{");

                items.append("\"item_id\":")
                     .append(rs.getInt("item_id"))
                     .append(",");

                items.append("\"item_name\":\"")
                     .append(rs.getString("item_name"))
                     .append("\",");

                items.append("\"description\":\"")
                     .append(rs.getString("description"))
                     .append("\",");

                items.append("\"category\":\"")
                     .append(rs.getString("category"))
                     .append("\",");

                items.append("\"location\":\"")
                     .append(rs.getString("location"))
                     .append("\",");

                items.append("\"date_lost\":\"")
                     .append(rs.getString("date_lost"))
                     .append("\",");

                items.append("\"contact\":\"")
                     .append(rs.getString("contact"))
                     .append("\"");

                items.append("}");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "[" + items.toString() + "]";
    }


    // ADD FOUND ITEM
    public static void addFoundItem(
        String itemName,
        String description,
        String category,
        String location,
        String dateFound,
        String contact
    ) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                "INSERT INTO found_items " +
                "(item_name, description, category, location, date_found, contact) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, itemName);
            ps.setString(2, description);
            ps.setString(3, category);
            ps.setString(4, location);
            ps.setString(5, dateFound);
            ps.setString(6, contact);

            ps.executeUpdate();

            System.out.println("Found item added successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // GET FOUND ITEMS
    public static String getFoundItems() {

        StringBuilder items = new StringBuilder();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM found_items";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (items.length() > 0) {
                    items.append(",");
                }

                items.append("{");

                items.append("\"item_id\":")
                     .append(rs.getInt("item_id"))
                     .append(",");

                items.append("\"item_name\":\"")
                     .append(rs.getString("item_name"))
                     .append("\",");

                items.append("\"description\":\"")
                     .append(rs.getString("description"))
                     .append("\",");

                items.append("\"category\":\"")
                     .append(rs.getString("category"))
                     .append("\",");

                items.append("\"location\":\"")
                     .append(rs.getString("location"))
                     .append("\",");

                items.append("\"date_found\":\"")
                     .append(rs.getString("date_found"))
                     .append("\",");

                items.append("\"contact\":\"")
                     .append(rs.getString("contact"))
                     .append("\"");

                items.append("}");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return "[" + items.toString() + "]";
    }

}