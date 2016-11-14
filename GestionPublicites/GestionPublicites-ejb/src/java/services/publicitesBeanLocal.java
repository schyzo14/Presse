/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.ejb.Local;
import presse.publicite;

/**
 *
 * @author Schyzo
 */
@Local
public interface publicitesBeanLocal {
    public publicite getPublicites(int num);
    public HashMap<Integer, publicite> getListePubs();
}
