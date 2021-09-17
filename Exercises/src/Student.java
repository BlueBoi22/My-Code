class Student{
    static int nextId = 0;

    final int id;
    final String firstName, lastName;

    Student(String fn, String ln){
        id = nextId;
        nextId++;

        firstName = fn;
        lastName = ln;
    }

    String getfirstName(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }
    void registerForCourse(Course c){
        c.registerStudent(this);
    }

    void unregisterforCourse(Course c){
        c.unregisterStudent(this);
    }
}