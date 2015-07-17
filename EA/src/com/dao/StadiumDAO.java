package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dto.StadiumDTO;
import com.dto.applyTeamDTO;



public class StadiumDAO {

	static SqlSessionFactory sqlSessionFactory;

	static {

		String resource = "com/dao/Configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}// end static
	
	
	
	public List<StadiumDTO> getStadiumList(){
		SqlSession session = sqlSessionFactory.openSession();
		List<StadiumDTO> list = null;
		try {
			list = session.selectList("stadiumList");
			
		} finally {
			session.close();
		}
		return list;
	}
	


	public int applyTeamList(applyTeamDTO dto) {
		SqlSession session = sqlSessionFactory.openSession();
		int n =0;
		try{
			n = session.insert("stadium.insert", dto);
			session.commit();
		}finally{
			session.close();
		}
		return n;
	}
	
	
	
	
	
}
