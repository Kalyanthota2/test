package com.spring.jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbcdemo.model.Circle;
@Component
public class JdbcDaoImpl {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
						public JdbcTemplate getJdbcTemplate() {
							return jdbcTemplate;
						}
						public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
							this.jdbcTemplate = jdbcTemplate;
						}
					
					
						public DataSource getDataSource() {
							return dataSource;
						}
						@Autowired
						public void setDataSource(DataSource dataSource) {
							this.jdbcTemplate=new JdbcTemplate(dataSource);
						}
		
	public Object getCircleCount(){
		
		String sql="SELECT COUNT(*) FROM circle";
		return jdbcTemplate.queryForList(sql);
		}
	
	public String getCircleName(int circleId)
	{
		String sql="SELECT name FROM circle WHERE id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, String.class);
	}
	
	public List<Circle> getAllCircles(){
		String sql="SELECT * FROM circle ";
		return jdbcTemplate.query(sql, new CircleMapper());

	}
	private static final class CircleMapper implements RowMapper
	{

		@Override
		public Object mapRow(ResultSet rs, int rowwNum) throws SQLException {
			Circle circle=new Circle();
			circle.setId(rs.getInt("Id"));
			circle.setName(rs.getString("name"));
			return circle;
		}
		
	}
	public void inserCircle(Circle circle)
	{
		String sql="INSERT INTO circle(id,name) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}
	/*public Circle getCircle(int circleId)
	{
		
		Connection conn=null;
		try
		{
			
		conn=dataSource.getConnection();
		PreparedStatement ps=conn.prepareStatement("SELECT * FROM circle where id=?");
		ps.setInt(1, circleId);
		Circle circle=null;
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			circle = new Circle(circleId, rs.getString("name"));
		}
		rs.close();
		ps.close();  
		return circle;
	
	}
	catch(Exception e)
	{
		throw new RuntimeException(e);
	}
		finally{
			try{
			conn.close();
			}
			catch(SQLException e){
				
			}
			
		}
	}*/
}
