package mx.edu.uttab.spring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice
public class JsonpCallbackAdvice extends AbstractJsonpResponseBodyAdvice {

	public JsonpCallbackAdvice() {
		super("callback");
	}
}
