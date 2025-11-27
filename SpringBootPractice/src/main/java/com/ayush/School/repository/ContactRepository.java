package com.ayush.School.repository;

import com.ayush.School.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByStatus(String status );


}

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public ContactRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public int saveContactMsg(Contact contact){
//        String sql = "INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS," +
//                "CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
//        return jdbcTemplate.update(sql, contact.getName(), contact.getPhone(),
//                contact.getEmail(),contact.getSubject(), contact.getMessage(), contact.getStatus(),contact.getCreatedAt(), contact.getCreatedBy());
//    }
//
