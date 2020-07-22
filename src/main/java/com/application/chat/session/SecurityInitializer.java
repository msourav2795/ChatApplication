package com.application.chat.session;

import org.apache.tomcat.util.descriptor.web.SessionConfig;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import com.hazelcast.config.SecurityConfig;

public class SecurityInitializer  extends AbstractSecurityWebApplicationInitializer{

	public SecurityInitializer() {
		super(SecurityConfig.class, SessionConfig.class);
	}

}
