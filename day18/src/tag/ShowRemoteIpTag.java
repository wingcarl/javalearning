package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.catalina.connector.Request;

public class ShowRemoteIpTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		String remoteIp = pageContext.getRequest().getRemoteAddr();
		try {
			pageContext.getOut().write(remoteIp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}
