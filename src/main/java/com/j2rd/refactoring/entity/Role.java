package com.j2rd.refactoring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId", nullable = false)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    public Role(final String admin)
    {
        this.name=name;
    }
    
    public Role()
    {
    
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(final String name)
    {
        this.name = name;
    }
    public Long getId()
    {
        return id;
    }
    
    public void setId(final Long id)
    {
        this.id = id;
    }
}
