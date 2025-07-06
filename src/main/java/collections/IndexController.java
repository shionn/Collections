package collections;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import collections.db.dao.IndexDao;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

	private final SqlSession session;
	
	@GetMapping("/")
	public ModelAndView root() {
			
		return new ModelAndView("index").addObject("items", session.getMapper(IndexDao.class).lastUpdate());
	}

	@GetMapping("/admin")
	public ModelAndView admin() {
		return new ModelAndView("admin");
	}

}
