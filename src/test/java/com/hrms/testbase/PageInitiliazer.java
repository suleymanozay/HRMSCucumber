package com.hrms.testbase;

import com.hrms.pages.AddCandidatePageElements;
import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.CandidatesPageWebElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;

public class PageInitiliazer extends BaseClass{
	
	protected static LoginPageElements login;
	protected static DashboardPageElements dahsboard;
	protected static AddEmployeePageElements addEmp;
	protected static PersonalDetailsPageElements pdetails;
	protected static CandidatesPageWebElements candidates;
	protected static AddCandidatePageElements addcandidates;
	
	public static void initializeAllPage() {
		
		login=new LoginPageElements();
		dahsboard=new DashboardPageElements();
	    addEmp = new AddEmployeePageElements();
	    pdetails= new PersonalDetailsPageElements();
	    candidates=new CandidatesPageWebElements();
	    addcandidates=new AddCandidatePageElements();
	}

}
