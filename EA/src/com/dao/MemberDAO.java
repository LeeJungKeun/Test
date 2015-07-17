package com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dto.MemeberDTO;
import com.dto.PageDTO;
import com.dto.TeamDTO;

/*
 create table board
 ( num number(4) primary key,
 author varchar2(20) not null,
 title vardhar2(20) not null,
 content varchar2(4000),
 writeday date default sysdate,
 readent number(4) default 0)

 */
public class MemberDAO {
	// mybatis가 lib에 있어야 요청수행시 파일을 가지고 메모리에 적재.

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

	
	
	
	
	public int insert(MemeberDTO dto) {

		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.insert("insert", dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	public int insertTeam(TeamDTO dto) {
		int n = 0;
		System.out.println("insertTeam DAO >>  " + dto.toString());
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.insert("insertTeam", dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	public int idcheck(MemeberDTO dto) {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.selectOne("idcheck", dto);
		} finally {
			session.close();
		}
		return n;
	}

	public int login(MemeberDTO dto) {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.selectOne("login", dto);
			System.out.println("   >>>> " + n);
			if (n == 1) {
				n = sessionSelect(dto);
			}
		} finally {
			session.close();
		}

		return n;
	}

	public int sessionSelect(MemeberDTO dto) {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.selectOne("session", dto);
		} finally {
			session.close();
		}
		return n;
	}

	public List<MemeberDTO> list() {
		List<MemeberDTO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("list");
		} finally {
			session.close();
		}
		return list;
	}

	public int totlaCount() {
		SqlSession session = sqlSessionFactory.openSession();

		int n = 0;
		try {
			n = session.selectOne("count");
		} finally {
			session.close();
		}
		return n;

	}

	public PageDTO page(int curPage) {
		PageDTO list = new PageDTO();

		int perPage = list.getPerPage();
		int skip = (curPage - 1) * perPage;
		int totalCount = totlaCount();

		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<MemeberDTO> xx = session.selectList("list", null,
					new RowBounds(skip, perPage));
			list.setList(xx);
			list.setCurPage(curPage);
			list.setTotalCount(totalCount);
		} finally {
			session.close();
		}
		return list;
	}

	public int write(MemeberDTO dto) {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.insert("insert", dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	public void readCnt(String num) {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.update("readCnt", Integer.parseInt(num));
			session.commit();
		} finally {
			session.close();
		}

	}

	// 글자세히 보게
	public MemeberDTO retrieve(String num) {
		//
		readCnt(num);
		MemeberDTO dto = null;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			dto = session.selectOne("selectByNum", Integer.parseInt(num));
			session.commit();
		} finally {
			session.close();
		}
		return dto;
	}

	// 글수정
	public int update(MemeberDTO dto) {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.update("update", dto);
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	// 글삭제
	public int delete(String num) {
		int n = 0;
		SqlSession session = sqlSessionFactory.openSession();
		try {
			n = session.delete("delete", Integer.parseInt(num));
			session.commit();
		} finally {
			session.close();
		}
		return n;
	}

	public List<MemeberDTO> search(String SearchName, String SearchValue) {
		List<MemeberDTO> list = null;

		System.out.println(SearchName + SearchValue);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("SearchName", SearchName);
		map.put("SearchValue", SearchValue);

		/*
		 * String key = "author"; if("title".equals(SearchName)){ key = "title";
		 * }
		 */

		SqlSession session = sqlSessionFactory.openSession();
		try {
			list = session.selectList("serch", map);
		} finally {
			session.close();
		}
		return list;
	}

}
