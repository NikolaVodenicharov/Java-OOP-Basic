public class Student extends Human{
    private final int FACULTY_NUMBER_MINIMUM_LENGTH = 5;
    private final int FACULTY_NUMBER_MAXIMUM_LENGTH = 50;

    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber){
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber){
        if (facultyNumber == null){
            throw new NullPointerException("Faculty number can not be null.");
        }
        if (facultyNumber.trim().length() == 0){
            throw new IllegalArgumentException("Faculty number can not be white space");
        }
        if(facultyNumber.length() < FACULTY_NUMBER_MINIMUM_LENGTH ||
            facultyNumber.length() > FACULTY_NUMBER_MAXIMUM_LENGTH){
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString(){
        StringBuilder formated = new StringBuilder();
        formated
                .append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Faculty number: %s", this.facultyNumber));
        return formated.toString();
    }
}
