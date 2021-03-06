package seedu.addressbook.data.employee;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Employee's email in the Rms.
 * Guarantees: immutable; is valid as declared in {@link #isValidEmail(String)}
 */
public class EmployeeEmail {
    public static final String EXAMPLE = "Example2018@rms.com";
    public static final String MESSAGE_EMAIL_CONSTRAINTS =
            "Employee emails should be 2 alphanumeric/period strings separated by '@'";
    public static final String EMAIL_VALIDATION_REGEX = "[\\w.]+@[\\w.]+";

    public final String value;

    /**
     * Empty constructor
     */
    public EmployeeEmail() {
        this.value = "";
    }

    /**
     * Validates given email.
     *
     * @throws IllegalValueException if given email address string is invalid.
     */
    public EmployeeEmail(String email) throws IllegalValueException {
        String trimmedEmail = email.trim();
        if (!isValidEmail(trimmedEmail)) {
            throw new IllegalValueException(MESSAGE_EMAIL_CONSTRAINTS);
        }
        this.value = trimmedEmail;
    }

    /**
     * Checks if a given string is a valid employee email.
     */
    public static boolean isValidEmail(String test) {
        return test.matches(EMAIL_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EmployeeEmail // instanceof handles nulls
                && this.value.equals(((EmployeeEmail) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
