package you.bacoder.kr.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private String targetUrlParameter;
	
	private String defaultUrl;
	
	private boolean useReferer;

	public CustomAuthenticationSuccessHandler() {
		targetUrlParameter = "loginRedirect";
		defaultUrl = "/";
		useReferer = false;
	}
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth)
			throws IOException, ServletException {
		// 로그인 이후 이동할 페이지
		String targetUrl = req.getParameter(targetUrlParameter);
		
		// 이동할 페이지로 redirect
		handle(req, resp, auth, targetUrl);
		
		// session 을 초기화 시킨다.
		clearAuthenticationAttributes(req);
	}
	
	
	/**
	 * 이동할 페이지로 redirect 한다.
	 * 
	 * @param request
	 * @param response
	 * @param authentication
	 * @param targetUrl
	 * @throws IOException
	 */
	protected void handle(HttpServletRequest request, 
		      HttpServletResponse response, Authentication authentication, String targetUrl)
		      throws IOException {
		if(targetUrl==null || targetUrl.length() == 0) {
			targetUrl = determineTargetUrl(authentication);
		}
		
        if (response.isCommitted()) {
            logger.debug(
              "Response has already been committed. Unable to redirect to "
              + targetUrl);
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
	
	protected String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        for (GrantedAuthority grantedAuthority : authorities) {
        	logger.info("grantedAuthority: " + grantedAuthority);
        	
            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }
        
        if (isUser) {
            return "/";
        } else if (isAdmin) {
            return "/";
        } else {
            throw new IllegalStateException();
        }
    }
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
	public String getTargetUrlParameter() {
		return targetUrlParameter;
	}
	public void setTargetUrlParameter(String targetUrlParameter) {
		this.targetUrlParameter = targetUrlParameter;
	}
	public String getDefaultUrl() {
		return defaultUrl;
	}
	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}
	public boolean isUseReferer() {
		return useReferer;
	}
	public void setUseReferer(boolean useReferer) {
		this.useReferer = useReferer;
	}
}
