package com.cozilyworks.cozily.compiler.codedom.element;

import com.cozilyworks.cozily.compiler.codedom.Visitable;

public class StringElement implements Visitable {
	public String content;

	public String visit() {
		return "\"" + content + "\"";
	}

}
