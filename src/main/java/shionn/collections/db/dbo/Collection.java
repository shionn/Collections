package shionn.collections.db.dbo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Collection {
	mangas("Mangas", Arrays.asList(Field.name, Field.author, Field.numbers, Field.complete),
			item -> item.setQty(numberToQty(item.getNumbers())), "book"), //
	bds("Bandes-dessinées",
			Arrays.asList(Field.name, Field.author, Field.editor, Field.category, Field.numbers,
					Field.complete),
			item -> item.setQty(numberToQty(item.getNumbers())), "book"), //
	books("Livres",
			Arrays.asList(Field.name, Field.author, Field.editor, Field.category, Field.year),
			item -> item.setQty(1),
			"book"), //
	comics("Comics",
			Arrays.asList(Field.name, Field.author, Field.editor, Field.category, Field.numbers,
					Field.complete),
			item -> item.setQty(numberToQty(item.getNumbers())), "book"), //
	videogames("Jeux vidéos",
			Arrays.asList(Field.name, Field.category, Field.plateform, Field.region), item -> {
				item.setQty(1);
				item.setCategory(item.getCategory().trim());
			}, "gamepad"), //
	vine("Vins", Arrays.asList(Field.name, Field.year, Field.category, Field.qty), null, "tint");

	private String title;
	private List<Field> fields;
	private Consumer<Item> decorator;
	private String fa;
	private int qty = 0;

	private Collection(String title, List<Field> fields, Consumer<Item> decorator, String fa) {
		this.title = title;
		this.fields = fields;
		this.decorator = decorator;
		this.fa = fa;
	}

	public String getTitle() {
		return title;
	}

	public List<Field> getFields() {
		return fields;
	}

	public Consumer<Item> getDecorator() {
		return decorator;
	}

	public String getFa() {
		return fa;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getQty() {
		return qty;
	}

	public enum Field {
		name("Nom", Type.string, null), //
		author("Auteur", Type.string, null), //
		numbers("Numeros", Type.string,
				items -> items.stream().collect(Collectors.summingInt(i -> i.getQty()))), //
		year("Année", Type.string, null), //
		editor("Editeur", Type.string, null), //
		category("Categorie", Type.string, null), //
		plateform("Plateforme", Type.img, null), //
		region("Region", Type.string, null), //
		qty("Quantité", Type.integer, null), //
		complete("Complet", Type.bool, null);
		private String title;
		private Type type;
		private Function<List<Item>, Object> decorator;

		private Field(String title, Type type, Function<List<Item>, Object> decorator) {
			this.title = title;
			this.type = type;
			this.decorator = decorator;
		}

		public String getTitle() {
			return title;
		}

		public Type getType() {
			return type;
		}

		public Function<List<Item>, Object> getDecorator() {
			return decorator;
		}

		public Object getDecorator(List<Item> items) {
			return decorator.apply(items);
		}

		public enum Type {
			string, bool, integer, img
		}

	}

	private static int numberToQty(String value) {
		int count = 0;
		for (String part : value.split(",")) {
			if (part.contains("-")) {
				String[] split = part.split("-");
				count += Integer.parseInt(split[1].trim()) - Integer.parseInt(split[0].trim()) + 1;
			} else {
				count++;
			}
		}
		return count;
	}

}
