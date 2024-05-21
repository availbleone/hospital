<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    boolean success = false;

    // 数据库连接信息
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "t";
    String password = "t";

    Connection conn = null;
    Statement stmt = null;

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
        String sql = "UPDATE doctor_orders SET status='Executed' WHERE id=" + id;
        int rows = stmt.executeUpdate(sql);
        if (rows > 0) {
            success = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (stmt != null) try { stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

    JSONObject result = new JSONObject();
    result.put("success", success);
    out.print(result.toString());
%>