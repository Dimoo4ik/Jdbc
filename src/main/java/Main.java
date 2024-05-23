import java.sql.Connection;import java.sql.DriverManager;
import java.sql.ResultSet;import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/slillbox";
        String user = "root";
        String password = "10052024";

        try {

            Connection connection = DriverManager.getConnection(url, user, password);//Подключение к MySql
            Statement statement = connection.createStatement();
            statement.execute("UPDATE courses SET name ='SQL for developments' " + "WHERE id=46");//Изменение чегото в базе данных

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String cursName = resultSet.getString("name");
                int duration = resultSet.getInt("duration");
                String type = resultSet.getString("type");
                String description = resultSet.getString("description");
                int teacherId = resultSet.getInt("teacher_id");
                int studentsCount = resultSet.getInt("students_count");
                int price = resultSet.getInt("price");
                float pricePerHour = resultSet.getFloat("price_per_hour");


                Courses courses = new Courses();

                courses.setId(id);
                courses.setName(cursName);
                courses.setDuration(duration);
                courses.setType(CoursesTupe.valueOf(type));
                courses.setDescription(description);
                courses.setTeacherId(teacherId);
                courses.setStudentsCount(studentsCount);
                courses.setPrice(price);
                courses.setPricePerHour(pricePerHour);

                System.out.println(courses);
            }
            connection.close();
            resultSet.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

