package minilib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import minilib.util.DBUtil;
import minilib.vo.CodeBookType;
import minilib.vo.Title;

public class ManageTitlesDao {
	
	public List findAll(){
		List list = new ArrayList();
		try{
		//建立数据库连接
		Connection conn=DBUtil.getConnection();
		
		//定义查询语句
		String sql="select * from t_book order by t_book.bookid";
		System.out.print("sql="+sql);
		PreparedStatement pstmt=conn.prepareStatement(sql);
		//查询获得结果集
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()){
			Title title = new Title();
		//	title.setBookid(rs.getString(1));
		//	title.setTypeid(rs.getString(2));
		//	System.out.print(rs.getString(2));
		//	title.setIsbn(rs.getString(3));
			title.setIsbn(rs.getString(3));
			title.setTitle(rs.getString(5));
		//	System.out.print(rs.getString(2));
			title.setAuthors(rs.getString(6));
			title.setPressid(rs.getString(8));
			list.add(title);
			}
		rs.close();
		pstmt.close();
		conn.close();
		
		}catch(InstantiationException e){
			e.printStackTrace();	
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			  e.printStackTrace();
		}catch(SQLException e){
			  e.printStackTrace();
		}
			
		return list;
	}
	
	public  List findBookType()
	throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException
	{
		List list = new ArrayList();
		Connection conn=DBUtil.getConnection();
		Statement stmt = conn.createStatement();
		//定义查询图书类型语句
		String strsql = "select ";
		strsql = strsql + "codeid,codename";
		strsql = strsql + " from code_booktype order by codeid ";
	
		System.out.print("********strsql="+strsql+"********");
	
		//获得查询图书结果集
		ResultSet rs = stmt.executeQuery(strsql);
		while (rs.next()){
			CodeBookType booktype = new CodeBookType();
			booktype.setCodeId(rs.getString(1));
			booktype.setCodeName(rs.getString(2));		
			//System.out.print(rs.getString(2));		
			list.add(booktype);
		}
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
	
	public void saveTitle(Title book)
	throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException
    {
		Connection conn=DBUtil.getConnection();
		String sql = "insert into t_book  (typeid,title) "
                   + "  values ('" + book.getTypeid()+"',"
                              + "'"+book.getTitle()+"'"		                                 
                              +" )";

		System.out.print("saveTitlesql="+sql);
		//执行插入操作
		Statement stmt;
		stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();   

    }


}


