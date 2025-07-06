package collections.db.dbo;

import java.util.function.Function;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum ItemField {
	author("author", "Auteur", o -> o.getAuthor()), //
	complete("complete", "Complet", o -> o.isComplete() ? "✅" : "❌"), //
	editor("editor", "Editor", o -> o.getAuthor()), //
	name("name", "Nom", o -> o.getName()), //
	numbers("numbers", "Numéros", o -> {
		return o.getNumbers();
	})

	;
	@Getter
	private final String field;
	@Getter
	private final String title;

	private final Function<Item, String> display;

	public String present(Item o) {
		return display.apply(o);
	}

	public boolean isBool() {
		return this == complete;
	}
}
