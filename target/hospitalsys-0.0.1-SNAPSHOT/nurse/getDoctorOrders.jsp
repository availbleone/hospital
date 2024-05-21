<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    // 数据库连接信息
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "t";
    String password = "t";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    JSONArray jsonArray = new JSONArray();

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
        String sql = "SELECT id, patient_name, doctor_name, medication_info, order_time, order_info FROM doctor_orders";
        rs = stmt.executeQuery(sql);

        while (rs.next()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", rs.getInt("id"));
            jsonObject.put("patientName", rs.getString("patient_name"));
            jsonObject.put("doctorName", rs.getString("doctor_name"));
            jsonObject.put("medicationInfo", rs.getString("medication_info"));
            jsonObject.put("orderTime", rs.getDate("order_time"));
            jsonObject.put("orderInfo", rs.getString("order_info"));

            jsonArray.put(jsonObject);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

    out.print(jsonArray.toString());
%>