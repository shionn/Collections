package collections.db.dbo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	private int id;
	private Collection collection;
	private Date updated;
	private String author;
	private boolean complete;
	private String name;
	private String numbers;


}
