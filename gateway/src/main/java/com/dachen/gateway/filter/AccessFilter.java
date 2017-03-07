package com.dachen.gateway.filter;

import org.apache.commons.lang3.StringUtils;

import com.netflix.zuul.ZuulFilter;

public class AccessFilter extends ZuulFilter implements IFilter {
	
	public Object run() {
		System.out.println("access checking.............");
		String accessToken = getRequest().getParameter("access-token");
		if (!validateToken(accessToken)) {
			getContext().setResponseStatusCode(401);
			getContext().setResponseBody("access-token invalid");
			getContext().setSendZuulResponse(false);
		}
		return null;
	}
	
	private boolean validateToken(String accessToken) {
		return true;
	}

	public boolean shouldFilter() {
		String token = getRequest().getParameter("access-token");
		if (StringUtils.isNotBlank(token)) {
			return true;
		}
		return false;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
