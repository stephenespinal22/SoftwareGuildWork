/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.daos;

import com.sg.classroster.dtos.Teacher;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author stephenespinal
 */
    public final class TeacherMapper implements RowMapper<Teacher> {

        public Teacher mapRow(ResultSet rs, int index) throws SQLException {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getInt("id"));
            teacher.setFirstName(rs.getString("firstName"));
            teacher.setLastName(rs.getString("lastName"));
            teacher.setSpecialty(rs.getString("specialty"));

            return teacher;
        }
    }
