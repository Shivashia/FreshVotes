package com.freshvotes.domains;

import jakarta.persistence.*;

@Entity
@Table(name="fetaures")
public class Feature {


    private Long f_id;
    private String f_description;
    private String status;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public Long getF_id() {
        return f_id;
    }

    public void setF_id(Long f_id) {
        this.f_id = f_id;
    }

    public String getf_description() {
        return f_description;
    }

    public void setf_description(String f_description) {
        this.f_description = f_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
