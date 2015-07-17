package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class IncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//체인 -> 걸어주는것(서로 연결)
		
		//요청필터
		request.setCharacterEncoding("utf-8");
		
		
		
		chain.doFilter(request, response); //다음필터 또는 서블릿으로 요청  //넘어가지 않는다. 넘겨주지 않는다.
		//응답필터
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
