package collections.db.dbo;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Model {
	manga(Arrays.asList(ItemField.name, ItemField.author, ItemField.numbers, ItemField.complete)),
	manga_group_by_autors(Arrays.asList(ItemField.name, ItemField.numbers, ItemField.complete)),
	ldvelh(Arrays.asList(ItemField.numbers, ItemField.name, ItemField.edition)),
	jeux_video(Arrays.asList(ItemField.name, ItemField.console)),
	jv_retro(Arrays.asList(ItemField.name, ItemField.console, ItemField.box, ItemField.manual));

	private final List<ItemField> fields;
}
