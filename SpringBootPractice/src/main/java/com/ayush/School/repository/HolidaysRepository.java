package com.ayush.School.repository;

import com.ayush.School.Model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public class HolidaysRepository {
//    private final JdbcTemplate jdbcTemplate;
//
//    public HolidaysRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Holiday> findAllHoliday(){
//        String sql = "select * from holidays";
//        var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
//        List<Holiday> holidays = jdbcTemplate.query(sql , rowMapper);
//        holidays.forEach(System.out::println);
//
//        return jdbcTemplate.query(sql , rowMapper);
//    }
//}

@Repository
public interface HolidaysRepository extends JpaRepository<Holiday , Integer > {

}
