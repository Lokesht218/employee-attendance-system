package com.lokesh.attendance.controller;

import com.lokesh.attendance.entity.Attendance;
import com.lokesh.attendance.repository.AttendanceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceRepository repository;

    public AttendanceController(AttendanceRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return repository.save(attendance);
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return repository.findAll();
    }

    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getAttendanceByEmployee(
            @PathVariable Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }
}