import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class DBInfo 
{
	static Connection con;
	static Vector<String> header;
	static Vector<Vector<String>> outer;
	static 
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement","root","rat");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static int insertValue(String s1,String str)
	{
		int i=0;
		String query = "Insert Into "+s1+" Values(?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setString(2, str.toUpperCase());
		    i = ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	public static Vector<String> getdate()
	{
		Vector<String> v = new Vector<>();
		String query = "select * from notice ";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}

	public static Vector<String> getAuthor()
	{
		Vector<String> v = new Vector<>();
		String query = "select * from author order by name";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public static Vector<String> getPublisher()
	{
		Vector<String> v = new Vector<>();
		String query = "select * from publisher order by name";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public static Vector<String> getCategory()
	{
		Vector<String> v = new Vector<>();
		String query = "select * from category order by name";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public static Vector<String> getSubject()
	{
		Vector<String> v = new Vector<>();
		String query = "select * from subject order by name";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			while(res.next())
			{
				v.add(res.getString(2));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public static void getAllIssued()
	{
		header = new Vector<>(); // store column name
		outer = new Vector<>();
		
		String query = "select * from issue";
		try {
			
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			//accessing meta data
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				String colName = rsmd.getColumnName(i);
				header.add(colName);
			}
			//getting records
			while(res.next())
			{
				Vector<String> records=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					String value=res.getString(i);
					records.add(value);
				}
				
				outer.add(records);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
    
	public static void getAllUser()
	{

		header = new Vector<>(); // store column name
		outer = new Vector<>();
		
		String query = "select * from registration";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			//accessing meta data
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				String colName = rsmd.getColumnName(i);
				header.add(colName);
			}
			//getting records
			while(res.next())
			{
				Vector<String> records=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					String value=res.getString(i);
					records.add(value);
				}
				
				outer.add(records);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void getAllBooks()
	{
		header = new Vector<>(); // store column name
		outer = new Vector<>();
		
		String query = "select * from book";
		try {
			
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			//accessing meta data
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				String colName = rsmd.getColumnName(i);
				header.add(colName);
			}
			//getting records
			while(res.next())
			{
				Vector<String> records=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					String value=res.getString(i);
					records.add(value);
				}
				
				outer.add(records);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void getbyid(String value , String id)
	{

		header = new Vector<>(); // store column name
		outer = new Vector<>();
		
		String query = "select * from issue where "+value+"=?";
		try {	
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet res=ps.executeQuery();
			//accessing meta data
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				String colName = rsmd.getColumnName(i);
				header.add(colName);
			}
			//getting records
			while(res.next())
			{
				Vector<String> records=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					String v=res.getString(i);
					records.add(v);
				}
				
				outer.add(records);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	
	public static void getValues(String value,String name)
	{
		header = new Vector<>(); // store column name
		outer = new Vector<>();
		
		String query = "select * from book where "+value+"=?";
		try {	
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet res=ps.executeQuery();
			//accessing meta data
			ResultSetMetaData rsmd=res.getMetaData();
			int colcount=rsmd.getColumnCount();
			for(int i=1;i<=colcount;i++)
			{
				String colName = rsmd.getColumnName(i);
				header.add(colName);
			}
			//getting records
			while(res.next())
			{
				Vector<String> records=new Vector<>();
				for(int i=1;i<=colcount;i++)
				{
					String v=res.getString(i);
					records.add(v);
				}
				
				outer.add(records);
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
