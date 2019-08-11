package P123;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VolgtOracleDaoImpl extends OracleBaseDao{
	public ArrayList<Volgt> findAll() throws SQLException {		
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ArrayList<Volgt> list = new ArrayList<Volgt>();
		
		String queryText = "SELECT * FROM volgt";
		ResultSet rs = stmt.executeQuery(queryText);
		
		while(rs.next()) {
			int id = rs.getInt("student_id");
			String code = rs.getString("vak_code");
			
			Volgt v = new Volgt(id, code);
			
			list.add(v);
		}
		rs.close();
		stmt.close();
		closeConnection();
		
		return list;
	}
    
	public ArrayList<Volgt> findVakkenByStudent(Student student) throws SQLException {		
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ArrayList<Volgt> list = new ArrayList<Volgt>();
		
		String queryText = "SELECT * FROM volgt WHERE student_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, student.getID());
		ResultSet rs = pstmt.executeQuery(queryText);
		
		while(rs.next()) {
			int id = rs.getInt("student_id");
			String code = rs.getString("vak_code");
			
			Volgt v = new Volgt(id, code);
			
			list.add(v);
		}
		
		rs.close();
		stmt.close();
		closeConnection();
		
		return list;
	}

	public Volgt save(Volgt volgt) throws SQLException {
		Connection conn = getConnection();
		
		String queryText = "INSERT INTO volgt VALUES (?,?)";
		PreparedStatement pstmt = conn.prepareStatement(queryText);
		pstmt.setInt(1, volgt.getStudentID());
		pstmt.setString(2, volgt.getVakCode());
		pstmt.executeUpdate();
		
		pstmt.close();
		closeConnection();
		
		return volgt;
	}

	public boolean delete(Volgt volgt) {
		try {
			Connection conn = getConnection();
			
			String queryText = "DELETE FROM volgt WHERE student_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(queryText);
			pstmt.setInt(1, volgt.getStudentID());
			pstmt.executeUpdate();
			
			pstmt.close();
			closeConnection();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
