package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Demo4Tag extends TagSupport {

	private int count;
	
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if((--count)>0){
			return IterationTag.EVAL_BODY_AGAIN;
		}else{
			return Tag.SKIP_BODY;
		}
	}

	@Override
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;
	}
	
}
