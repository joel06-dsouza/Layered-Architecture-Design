package in.mindcraft.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import in.mindcraft.pojos.Laptop;
import in.mindcraft.utils.DBUtils;

public class LaptopDao {

	private Connection cn;
	
	private PreparedStatement psmt;
	private PreparedStatement psmt2;
	
	public void addLaptop(Laptop laptop) throws SQLException, ClassNotFoundException {
		
		cn = DBUtils.openConnect();
		
		psmt = cn.prepareStatement("Insert into laptop values (?,?,?)");
			
		psmt.setInt(1, laptop.getLid());
		psmt.setString(2, laptop.getMake());
		psmt.setDouble(3, laptop.getCost());
		
		psmt.execute();
		
		DBUtils.closeConnect();
	}
	

	public List<Laptop> showLaptop() throws ClassNotFoundException, SQLException {
		cn = DBUtils.openConnect();
		
		
		List<Laptop> list = new ArrayList<Laptop>();
		
		psmt2 = cn.prepareStatement("select * from laptop");
		
		ResultSet rst = psmt2.executeQuery();
		
		while(rst.next()) {
			list.add(new Laptop(rst.getInt(1), rst.getString(2), rst.getDouble(3)));
		}
		
		DBUtils.closeConnect();
		return list;
	}

}
