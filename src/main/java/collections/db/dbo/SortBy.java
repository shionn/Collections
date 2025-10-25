package collections.db.dbo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Comparator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SortBy {

	edition((a, b) -> a.getEdition().compareTo(b.getEdition())),
	name((a, b) -> a.getName().compareTo(b.getName())),
	number((a, b) -> {
		try {
			NumberFormat format = NumberFormat.getIntegerInstance();
			return Integer.compare(format.parse(a.getNumbers()).intValue(), format.parse(b.getNumbers()).intValue());
		} catch (ParseException e) {
			return 0;
		}
	}),
	edition_number((a, b) -> {
		int c = edition.comparator.compare(a, b);
		return c == 0 ? number.comparator.compare(a, b) : c;
	});

	private final Comparator<Item> comparator;

}
