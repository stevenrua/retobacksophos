package com.retotecnico.entities;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "affiliates")
public class AffiliatesEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_affiliates")
    private long idAffiliate;
    
    @NotNull
    private String name;
    
    @NotNull
    private int age;
    
    @NotNull
    @Column(unique = true)
    private String email;
    
    
    
    public AffiliatesEntity(){}

    public AffiliatesEntity(long idAffiliate) {
        this.idAffiliate = idAffiliate;
    }

    public AffiliatesEntity(long idAffiliate, String name, int age, String email) {
        this.idAffiliate = idAffiliate;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public AffiliatesEntity(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    

    public long getIdAffiliate() {
        return idAffiliate;
    }

    public void setIdAffiliate(long idAffiliate) {
        this.idAffiliate = idAffiliate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EntityAffiliates{idAffiliate=").append(idAffiliate);
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", email=").append(email);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.idAffiliate ^ (this.idAffiliate >>> 32));
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + Objects.hashCode(this.age);
        hash = 13 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AffiliatesEntity other = (AffiliatesEntity) obj;
        if (this.idAffiliate != other.idAffiliate) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.age, other.age)) {
            return false;
        }
        return true;
    }
}
