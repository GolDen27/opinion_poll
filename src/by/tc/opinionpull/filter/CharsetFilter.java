package by.tc.opinionpull.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {

	private String encoding = "utf-8";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String encodingParam = filterConfig.getInitParameter("characterEncoding");
		if (encodingParam != null) {
			encoding = encodingParam;
		}
	}

	@Override
	public void destroy() {
		// nothing todo
	}
}
