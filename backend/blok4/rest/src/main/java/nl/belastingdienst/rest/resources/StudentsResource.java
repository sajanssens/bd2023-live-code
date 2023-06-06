package nl.belastingdienst.rest.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import nl.belastingdienst.rest.domain.Student;
import nl.belastingdienst.rest.domain.StudentInput;

import java.util.List;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.util.UUID.randomUUID;

@Path("students")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class StudentsResource {

    List<Student> students = List.of(new Student("1", "Bram"), new Student("2", "Bram2"));

    @GET  // students?name=bram
    public List<Student> search(@QueryParam("name") String name) {
        return name != null ?
                this.students.stream()
                        .filter(s -> s.name().equals(name))
                        .toList() :
                this.students;
    }

    @GET @Path("{id}") // students/<een-id>
    public Student getStudent(@PathParam("id") String id) {
        return this.students.get(Integer.parseInt(id));
    }

    @POST
    public Student add(StudentInput input) {
        Student newStudent = new Student(randomUUID().toString(), input.name());
        this.students.add(newStudent);
        return newStudent;
    }
}
