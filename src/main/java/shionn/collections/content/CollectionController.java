package shionn.collections.content;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import shionn.collections.db.dao.CollectionDao;
import shionn.collections.db.dbo.Collection;
import shionn.collections.db.dbo.Item;

@Controller
public class CollectionController {

	@Autowired
	private SqlSession session;

	@RequestMapping(path = "/{collection}", method = RequestMethod.GET)
	public ModelAndView list(@PathVariable Collection collection) {
		List<Item> items = session.getMapper(CollectionDao.class).list(collection);
		if (collection.getDecorator() != null) {
			items.stream().forEach(collection.getDecorator());
		}
		return new ModelAndView("collection") //
				.addObject("collection", collection) //
				.addObject("items", items);
	}

	@RequestMapping(path = "/{collection}", method = RequestMethod.POST)
	public String add(@PathVariable Collection collection, @ModelAttribute Item item) {
		if (collection.getDecorator() != null) {
			collection.getDecorator().accept(item);
		}
		item.setCollection(collection);
		session.getMapper(CollectionDao.class).insert(item);
		session.commit();
		return "redirect:/" + collection.name() + "#form";
	}

	@RequestMapping(path = "/{collection}/edit/{id}", method = RequestMethod.GET)
	public ModelAndView open(@PathVariable("collection") Collection collection,
			@PathVariable("id") int id) {
		return new ModelAndView("edit")//
				.addObject("collection", collection)//
				.addObject("item", session.getMapper(CollectionDao.class).read(id));
	}

	@RequestMapping(path = "/{collection}/edit/{id}", method = RequestMethod.POST)
	public String save(@PathVariable("collection") Collection collection,
			@ModelAttribute Item item) {
		if (collection.getDecorator() != null) {
			collection.getDecorator().accept(item);
		}
		session.getMapper(CollectionDao.class).save(item);
		session.commit();
		return "redirect:/" + collection.name();
	}

}
