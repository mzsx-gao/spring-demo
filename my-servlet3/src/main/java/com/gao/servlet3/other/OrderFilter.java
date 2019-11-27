package com.gao.servlet3.other;

import javax.servlet.*;
import java.io.IOException;

public class OrderFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		//过滤请求
		System.err.println("OrderFilter....doFilter.....");
		//放行
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
