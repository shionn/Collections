package shionn.collections.content;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shionn.collections.db.dao.CollectionDao;
import shionn.collections.db.dbo.Collection;

@Controller
public class IndexController {

	@Autowired
	private SqlSession session;

	@RequestMapping("/")
	public ModelAndView index() {
		session.getMapper(CollectionDao.class).listCollections().stream()
				.forEach(item -> item.getCollection().setQty(item.getQty()));
		return new ModelAndView("index").addObject("collections", Collection.values());
	}

}
