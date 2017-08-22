
package com.tca.service;
import com.tca.entity.GeneralLicensee;

import java.util.List;

import org.springframework.data.domain.Page;

/**
 * @author Fan
 * @version 1.0
 */
public interface GeneralLicenseeService {
	public GeneralLicensee createGeneralLicensee(GeneralLicensee generalLicensee);
    public GeneralLicensee updateGeneralLicensee(GeneralLicensee generalLicensee);
    public void deleteGeneralLicensee(long id);
    public List<GeneralLicensee> getAllGeneralLicensees();
    public GeneralLicensee getGeneralLicensee(long id);	
	public List<GeneralLicensee> getAllGeneralLicensees(String generalLicenseeName);
	public Page<GeneralLicensee> getGeneralLicenseePage(Integer pageNumber, Integer pageSize, String sortColumn,String name,String city, String address, String postCode) ;
}
