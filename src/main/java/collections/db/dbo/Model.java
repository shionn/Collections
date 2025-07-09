package collections.db.dbo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Model {
	manga(Arrays.asList(ItemField.name, ItemField.author, ItemField.numbers, ItemField.complete),
			(a, b) -> a.getName().compareTo(b.getName())),
	manga_group_by_autors(Arrays.asList(ItemField.name, ItemField.numbers, ItemField.complete),
			(a, b) -> a.getName().compareTo(b.getName())),
	ldvelh(Arrays.asList(ItemField.numbers, ItemField.name, ItemField.edition),
			(a, b) -> Integer.compare(Integer.parseInt(a.getNumbers()), Integer.parseInt(b.getNumbers())));

	private final List<ItemField> fields;
	private final Comparator<Item> comparator;
}
