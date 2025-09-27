package collections.db.dbo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Comparator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SortBy {

	name((a, b) -> a.getName().compareTo(b.getName())), number((a, b) -> {
		try {
			NumberFormat format = NumberFormat.getIntegerInstance();
			return Integer.compare(format.parse(a.getNumbers()).intValue(), format.parse(b.getNumbers()).intValue());
		} catch (ParseException e) {
			return 0;
		}
	});

	private final Comparator<Item> comparator;

}
