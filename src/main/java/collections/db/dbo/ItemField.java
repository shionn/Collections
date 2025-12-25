package collections.db.dbo;

import java.util.function.Function;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum ItemField {
	author("author", "Auteur", o -> o.getAuthor(), false), //
	box("box", "Boite", o -> o.isBox() ? "✅" : "❌", true), //
	complete("complete", "Complet", o -> o.isComplete() ? "✅" : "❌", true), //
	console("console", "Console", o -> "<img src=\"img/console/" + o.getConsole() + ".png\"/>", false), //
	editor("editor", "Editor", o -> o.getEditor(), false), //
	edition("edition", "Edition", o -> o.getEdition(), false), //
	manual("manual", "Manuel", o -> o.isManual() ? "✅" : "❌", true), //
	name("name", "Nom", o -> o.getName(), false), //
	numbers("numbers", "Numéros", o -> o.getNumbers(), false)

	;
	@Getter
	private final String field;
	@Getter
	private final String title;

	private final Function<Item, String> display;

	@Getter
	private final boolean bool;

	public String present(Item o) {
		return display.apply(o);
	}

}
