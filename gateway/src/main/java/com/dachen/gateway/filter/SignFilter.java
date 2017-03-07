package com.dachen.gateway.filter;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.netflix.zuul.ZuulFilter;

public class SignFilter extends ZuulFilter implements IFilter {

	public boolean shouldFilter() {
		String sign = getRequest().getParameter("sign");
		if (StringUtils.isNotBlank(sign)) {
			return true;
		}
		return true;
	}

	public Object run() {
		System.out.println("sign checking.............");
		Map<String, String[]> paramMap = getRequest().getParameterMap();
		for (Iterator<String> it = paramMap.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			String[] strArr = paramMap.get(key);
			for (String str : strArr)
				System.out.println("key: " + key + ", paramMap: " + str);
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
