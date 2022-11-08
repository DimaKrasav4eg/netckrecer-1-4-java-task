package mission_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class Person {
	//long   '12 January 1952'
	//medium '12 Jan 1952'
	//short  '12.11.52'
	//
	private LocalDate birthday;
	//format type
	Format format;
	//format patterns
	private final static String SHORT_PATTERN  = "dd.MM.yy";
	private final static String MEDIUM_PATTERN = "dd MMM yyyy";
	private final static String LONG_PATTERN   = "dd MMMM yyyy";
	
	public void setBirthday(String birthday) {
		try {
			setBirthday(birthday, Person.SHORT_PATTERN);
			this.format = Format.SHORT;
		} catch (DateTimeParseException e1) {
			try {
				setBirthday(birthday, Person.MEDIUM_PATTERN);
				this.format = Format.MEDIUM;
			} catch (DateTimeParseException e2) {
				try {
					setBirthday(birthday, Person.LONG_PATTERN);
					this.format = Format.LONG;
				} catch (DateTimeParseException e3) {
					throw new IllegalArgumentException("incorrect argument");
				}
			}
		}
	}
	//set birthday by pattern
	private void setBirthday(String birthday, String pattern) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
		this.birthday = LocalDate.parse(birthday, format);
	}
	//return birthday
	public String getBirthday() {
		return this.birthday.format(DateTimeFormatter.ofPattern(this.format.toString()));
	}
	
	@Override
	public String toString() {
		return this.birthday.toString() + this.format.toString();
	}
	
	private enum Format{
		SHORT("dd.MM.yy"),
		MEDIUM("dd MMM yyyy"),
		LONG("dd MMMM yyyy");
		
		private String value;
		
		Format(String value) {
			this.value = value;
		}
		@Override
	    public String toString() {
	        return value;
	    }
	}
}
