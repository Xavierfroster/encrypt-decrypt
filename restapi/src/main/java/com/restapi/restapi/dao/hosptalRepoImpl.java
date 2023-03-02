
package com.restapi.restapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.restapi.restapi.modal.HospitalModal;

/**
 * hosptalRepoImpl
 */

 @Repository
public class hosptalRepoImpl implements HospitalRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   @Override
   public List<HospitalModal> getHospitalModalsList() {
       String strQuery = "";
        try {
            strQuery = "select * from cdst_hospital_mst_testing1";
            List<HospitalModal> list = jdbcTemplate.query(strQuery, BeanPropertyRowMapper.newInstance(HospitalModal.class));
            return list;
        } catch (Exception e) {
            System.out.println("Error Repository ");
            System.out.println(e.getMessage());
            return null;
        }

   }

    
}