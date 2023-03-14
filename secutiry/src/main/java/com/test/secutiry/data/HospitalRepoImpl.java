package com.test.secutiry.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.secutiry.model.HospitalModal;

@Repository
public class HospitalRepoImpl implements HospitalRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<HospitalModal> getAllHospitalNames() {
        
        String Query="";
        try {
            
            Query = "select * from cdst_hospital_mst_testing1";
            List<HospitalModal> list = jdbcTemplate.query(Query, BeanPropertyRowMapper.newInstance(HospitalModal.class));
            return list;
        } catch (Exception e) {
            System.out.println("Execption Caught at Repository >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+e.getMessage());
            return null;
        }

    }

    
    
}
