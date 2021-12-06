package com.neosoft.Studentapi.Controller;

import com.neosoft.Studentapi.Entity.Project;
import com.neosoft.Studentapi.Entity.Student;
import com.neosoft.Studentapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "students/register" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> registerStudent(@RequestBody Student student){

        return ResponseEntity.ok(userService.registerStudent(student));
    }

    @GetMapping(value = "students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentDetails(@PathVariable int id){
        return ResponseEntity.ok(userService.getStudent(id));
    }

    @GetMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(userService.getAllStudents());
    }


//    @PostMapping(value = "projects/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasAuthority('project:write')")
//    public ResponseEntity<Project> createProject(@RequestBody Project project){
//        return ResponseEntity.ok(projectService.createProject(project));
//    }
//
//
//    @GetMapping("projects/{id}")
//    @PreAuthorize("hasAuthority('project:read')")
//    public ResponseEntity<Project> getProject(@PathVariable int id){
//        return ResponseEntity.ok(projectService.getProject(id));
//    }
//
//    @PutMapping("projects/{id}")
//    @PreAuthorize("hasAuthority('project:write')")
//    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project project){
//        return ResponseEntity.ok(projectService.updateProject(id,project));
//    }




}
