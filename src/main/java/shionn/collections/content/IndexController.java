package shionn.collections.content;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shionn.collections.db.dbo.Collection;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index").addObject("collections", Collection.values());
	}

}
