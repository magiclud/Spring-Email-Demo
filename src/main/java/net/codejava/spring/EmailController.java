package net.codejava.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sendEmail")
public class EmailController {
	@Autowired
	private JavaMailSenderImpl mailSender;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView sendEmail() {

		ModelAndView model = new ModelAndView("email");
		model.addObject("host", mailSender.getHost());
		model.addObject("port", mailSender.getPort());
		model.addObject("user", mailSender.getUsername());
		model.addObject("pass", mailSender.getPassword());

		return model;
	}
}
