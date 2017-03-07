package com.dachen.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.context.RequestContext;

public interface IFilter {

	default RequestContext getContext() {
		return RequestContext.getCurrentContext();
	}
	
	default HttpServletRequest getRequest() {
		return getContext().getRequest();
	}
}
