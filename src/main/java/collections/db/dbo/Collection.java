package collections.db.dbo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
	private int id;
	private String name;
	private Model model;
	private SortBy sortBy;
	private List<Collection> groups;
	private List<Item> items;
	private String description;
}
