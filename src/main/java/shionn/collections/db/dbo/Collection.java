package shionn.collections.db.dbo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Collection {
	mangas("Mangas", Arrays.asList(Field.name, Field.author, Field.numbers, Field.complete),
			item -> item.setQty(numberToQty(item.getNumbers()))), //
	vine("Vins", Arrays.asList(Field.name), null);

	private String title;
	private List<Field> fields;
	private Consumer<Item> decorator;

	private Collection(String title, List<Field> fields, Consumer<Item> decorator) {
		this.title = title;
		this.fields = fields;
		this.decorator = decorator;
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

	public enum Field {
		name("Nom", Type.string, null), //
		author("Auteur", Type.string, null), //
		numbers("Numeros", Type.string,
				items -> items.stream().collect(Collectors.summingInt(i -> i.getQty()))), //
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
			string, bool
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
