package collections;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import collections.db.dao.CollectionsDao;
import collections.db.dbo.Collection;
import collections.db.dbo.Item;
import lombok.RequiredArgsConstructor;

@Controller()
@RequiredArgsConstructor
@RequestMapping(path = "/{collection-id}")
public class CollectionsController {

	private final SqlSession session;
	
	@GetMapping
	public ModelAndView view() {
		return new ModelAndView("collection");
	}

	@GetMapping("add")
	public ModelAndView add() {
		return new ModelAndView("item-add");
	}

	@PostMapping("add")
	public String add(@PathVariable("collection-id") int collectionId, @ModelAttribute Item item) {
		CollectionsDao dao = session.getMapper(CollectionsDao.class);
		dao.createItem(collectionId, item);
		session.commit();
		return "redirect:/" + collectionId;
	}

	@GetMapping("{item-id}/edit")
	public ModelAndView edit(@PathVariable("item-id") int itemId) {
		CollectionsDao dao = session.getMapper(CollectionsDao.class);
		return new ModelAndView("item-edit").addObject("item", dao.readItem(itemId));
	}

	@PostMapping("{item-id}/edit")
	public String edit(@PathVariable("collection-id") int collectionId, @PathVariable("item-id") int itemId,
			@ModelAttribute Item item) {
		item.setId(itemId);
		CollectionsDao dao = session.getMapper(CollectionsDao.class);
		dao.updateItem(item);
		session.commit();
		return "redirect:/" + collectionId;
	}

	@ModelAttribute
	public Collection collection(@PathVariable("collection-id") int id) {
		return sort(session.getMapper(CollectionsDao.class).list(id));
	}

	private Collection sort(Collection source) {
		source.getGroups().forEach(this::sort);
		source.getItems().sort(source.getModel().getComparator());
		return source;
	}
}
