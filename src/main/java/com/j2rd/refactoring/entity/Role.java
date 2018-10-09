package com.j2rd.refactoring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author Omid Panahi omidpan4@gmail.com
 *
 *  The Schema name has been selected just for fun
 * @role
 * it does not have any id since I don't have time to finish it
 */

@Entity
@Table(name = "Role", schema = "JAVATEST")
public class Role
{
    
    @Column(name = "RoleName", nullable = false)
    private String roleName;
    
    public String getRoleName()
    {
        return roleName;
    }
    
    public void setRoleName(final String roleName)
    {
        this.roleName = roleName;
    }
}
