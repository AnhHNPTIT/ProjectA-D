/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Rank;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author skull
 */
@Local
public interface RankFacadeLocal {

    void create(Rank rank);

    void edit(Rank rank);

    void remove(Rank rank);

    Rank find(Object id);

    List<Rank> findAll();

    List<Rank> findRange(int[] range);

    int count();
    
}
