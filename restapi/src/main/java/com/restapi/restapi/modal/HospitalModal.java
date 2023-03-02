package com.restapi.restapi.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class HospitalModal {
    
    private int gnum_project_code;
    private int gnum_hospital_code;
    private String gstr_hospital_name;
    private int gnum_state_code;
    private int num_district_id;

}
