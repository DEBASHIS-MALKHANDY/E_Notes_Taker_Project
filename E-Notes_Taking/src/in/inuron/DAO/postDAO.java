package in.inuron.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.inuron.user.Post;

public class postDAO {
	
	private Connection conn;

	public postDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	//add note method

	public boolean addNotes(String ti, String co, int ui) {
		boolean f = false;
		try {
			String queryString = "insert into post(title,content,uid) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(queryString);
			pstmt.setString(1, ti);
			pstmt.setString(2, co);
			pstmt.setInt(3, ui);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	public List<Post> getData(int id) {
		List<Post> list = new ArrayList<Post>();
		Post po = null;
		try {
			String query = "select * from post where uid=? order by id DESC";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rSet = pstmt.executeQuery();
			while (rSet.next()) {

				po = new Post();

				po.setId(rSet.getInt(1));
				po.setTitle(rSet.getString(2));
				po.setContent(rSet.getString(3));
				po.setpDate(rSet.getTimestamp(4));
				list.add(po);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Post getDataById(int noteId) {

		Post p = null;
		try {
			String queryString = "select * from post where id=?";
			PreparedStatement pstmt1 = conn.prepareStatement(queryString);
			pstmt1.setInt(1, noteId);
			ResultSet resultSet = pstmt1.executeQuery();
			while (resultSet.next()) {
				p = new Post();
				p.setId(resultSet.getInt(1));
				p.setTitle(resultSet.getString(2));
				p.setContent(resultSet.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}
	
public boolean PostUpdate(String title,String content,int nid) {
		
		boolean f=false;
		
		
		try {
			String updatequString="update post set title=?,content=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(updatequString);
			pstmt.setString(1, title);
			pstmt.setString(2,content);
			pstmt.setInt(3, nid);
			int i=pstmt.executeUpdate();
			if (i==1) {
				f=true;
				
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return f;
		
	}
	
public boolean deleteNotes(int nid){
	
	boolean f=false;
	
	try {
		
		String deleteString="delete from post where id=?";
		PreparedStatement pstmt=conn.prepareStatement(deleteString);
		pstmt.setInt(1, nid);
		int delete=pstmt.executeUpdate();
		if (delete==1) {
			f=true;
		}
		
	} catch (Exception e) {
	e.printStackTrace();
	}
	return f;
	
}



	
	
	
	//get data in the form of list 
	

}
