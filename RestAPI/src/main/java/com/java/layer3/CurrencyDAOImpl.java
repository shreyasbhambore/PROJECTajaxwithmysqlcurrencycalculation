package com.java.layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.layer2.Currency;
import com.java.layer4.Currencynotfound;

public class CurrencyDAOImpl implements CurrencyDAO {

	Connection conn;
	public CurrencyDAOImpl() {
		System.out.println("trying to load the driver");
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("\n\n trying to connect to the DB");
			this.conn= DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","1234");
			System.out.println("connected to the DB"+conn); 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("driver loaded...");
		
	}
	
	
	@Override
	public Currency selectCurrency(int id) throws Currencynotfound {
		Currency curr = new Currency();
		try {
			Statement stmt=conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from currency where currency_id="+id);
			if(resultSet.next()) {
			curr.setCurrencyId(resultSet.getInt(1));
			curr.setSourceCurrency(resultSet.getString(2));
			curr.setTargetcurrency(resultSet.getString(3));
			curr.setLoadFactor(resultSet.getFloat(4));
			}
			else {
				throw new Currencynotfound("currency not found");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return curr;
	}

	@Override
	public List<Currency> selectAll() {
		List<Currency> list = new ArrayList<Currency>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from currency");
			while (resultSet.next()) {
				   Currency curr = new Currency();
				   curr.setCurrencyId(resultSet.getInt(1));
				   curr.setSourceCurrency(resultSet.getString(2));
				   curr.setTargetcurrency(resultSet.getString(3));
				   curr.setLoadFactor(resultSet.getFloat(4));
                    list.add(curr);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void insertCurrency(Currency temp) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into currency (source_currency,target_currency,loadFactor) values(?,?,?)");
			pstmt.setString(1, temp.getSourceCurrency());
			pstmt.setString(2, temp.getTargetcurrency());		
			pstmt.setFloat(3, temp.getLoadFactor());
			
			int row = pstmt.executeUpdate();
			System.out.println("information added to Database ,"+row+" effected");
			pstmt.close();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}

	}

	@Override
	public void updateCurrency(Currency temp) {
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("update currency set currency_source=?, currency_target=?, currency_amount=? where currency_id=?");
			pst.setString(1, temp.getSourceCurrency());
			pst.setString(2, temp.getTargetcurrency());
			pst.setFloat(3, temp.getLoadFactor());
			pst.setInt(4, temp.getCurrencyId());
			int rows = pst.executeUpdate(); //run the insert query
			System.out.println("4. executed the update query : "+rows+ " row(s) inserted");
			pst.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

	}

	@Override
	public void deleteCurrency(int id) {
		try {
			PreparedStatement pst = conn.prepareStatement("delete from currency where currency_id=?");
			pst.setInt(1, id);
			int rows = pst.executeUpdate();
			if(rows == 0) {
				System.out.println("Rocord not found");
			}else {
				System.out.println("record deleted");
			}
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
