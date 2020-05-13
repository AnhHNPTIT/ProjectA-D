/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Voucher;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author skull
 */
@Local
public interface VoucherFacadeLocal {

    void create(Voucher voucher);

    void edit(Voucher voucher);

    void remove(Voucher voucher);

    Voucher find(Object id);

    List<Voucher> findAll();

    List<Voucher> findRange(int[] range);

    int count();
    
}
