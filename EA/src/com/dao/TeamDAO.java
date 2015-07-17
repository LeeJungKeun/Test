package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dto.TeamDTO;

public class TeamDAO {

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
	}
	
	//팀찾기
		public List<TeamDTO> searchTeam(String teamName) {
			SqlSession session = sqlSessionFactory.openSession();
			List<TeamDTO> list = null;
			if (teamName == null) {		//null이면 팀 전체 뽑기
				try {
					list = session.selectList("searchAllTeam");
				} finally {
					session.close();
				}
				return list;
				
			} else {					//null이 아니면 검색한 팀 출력
				try {
					list = session.selectList("searchTeam", teamName);

				} finally {
					session.close();
				}

				return list;
			}
		}

}
