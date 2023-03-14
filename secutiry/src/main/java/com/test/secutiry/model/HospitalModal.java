package com.test.secutiry.model;




public class HospitalModal {


    private int gnum_hospital_code;

    private int gnum_project_code;

    private String gstr_hospital_name;

    private String gdt_entry_date;

    private String gnum_tot_opd;

    private int gnum_tot_ipd;
    
    private int gnum_tot_invt;

	public HospitalModal() {

	}

	public HospitalModal(int gnum_hospital_code, int gnum_project_code, String gstr_hospital_name, String gdt_entry_date,
			String gnum_tot_opd, int gnum_tot_ipd, int gnum_tot_invt) {
		super();
		this.gnum_hospital_code = gnum_hospital_code;
		this.gnum_project_code = gnum_project_code;
		this.gstr_hospital_name = gstr_hospital_name;
		this.gdt_entry_date = gdt_entry_date;
		this.gnum_tot_opd = gnum_tot_opd;
		this.gnum_tot_ipd = gnum_tot_ipd;
		this.gnum_tot_invt = gnum_tot_invt;
	}

	public int getGnum_hospital_code() {
		return gnum_hospital_code;
	}

	public void setGnum_hospital_code(int gnum_hospital_code) {
		this.gnum_hospital_code = gnum_hospital_code;
	}

	public int getGnum_project_code() {
		return gnum_project_code;
	}

	public void setGnum_project_code(int gnum_project_code) {
		this.gnum_project_code = gnum_project_code;
	}

	public String getGstr_hospital_name() {
		return gstr_hospital_name;
	}

	public void setGstr_hospital_name(String gstr_hospital_name) {
		this.gstr_hospital_name = gstr_hospital_name;
	}

	public String getGdt_entry_date() {
		return gdt_entry_date;
	}

	public void setGdt_entry_date(String gdt_entry_date) {
		this.gdt_entry_date = gdt_entry_date;
	}

	public String getGnum_tot_opd() {
		return gnum_tot_opd;
	}

	public void setGnum_tot_opd(String gnum_tot_opd) {
		this.gnum_tot_opd = gnum_tot_opd;
	}

	public int getGnum_tot_ipd() {
		return gnum_tot_ipd;
	}

	public void setGnum_tot_ipd(int gnum_tot_ipd) {
		this.gnum_tot_ipd = gnum_tot_ipd;
	}

	public int getGnum_tot_invt() {
		return gnum_tot_invt;
	}

	public void setGnum_tot_invt(int gnum_tot_invt) {
		this.gnum_tot_invt = gnum_tot_invt;
	}

	@Override
	public String toString() {
		return "Hospital [gnum_hospital_code=" + gnum_hospital_code + ", gnum_project_code=" + gnum_project_code
				+ ", gstr_hospital_name=" + gstr_hospital_name + ", gdt_entry_date=" + gdt_entry_date
				+ ", gnum_tot_opd=" + gnum_tot_opd + ", gnum_tot_ipd=" + gnum_tot_ipd + ", gnum_tot_invt="
				+ gnum_tot_invt + "]";
	}
    
}
