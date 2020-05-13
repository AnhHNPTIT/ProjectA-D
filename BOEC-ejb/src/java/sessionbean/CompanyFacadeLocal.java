/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Company;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author skull
 */
@Local
public interface CompanyFacadeLocal {

    void create(Company company);

    void edit(Company company);

    void remove(Company company);

    Company find(Object id);

    List<Company> findAll();

    List<Company> findRange(int[] range);

    int count();
    
}
