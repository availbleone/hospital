<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2024/5/21
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    response.setContentType("application/json; charset=UTF-8");
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    JSONArray jsonArray = new JSONArray();
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "t", "t");

        String sql = "SELECT id, patient_name, doctor_name, medication_info, order_time, order_info FROM doctor_orders";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            JSONObject obj = new JSONObject();
            obj.put("id", rs.getInt("id"));
            obj.put("patient_name", rs.getString("patient_name"));
            obj.put("doctor_name", rs.getString("doctor_name"));
            obj.put("medication_info", rs.getString("medication_info"));
            obj.put("order_time", rs.getTimestamp("order_time").toString());
            obj.put("order_info", rs.getString("order_info"));
            jsonArray.put(obj);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
    out.print(jsonArray.toString());
%>

