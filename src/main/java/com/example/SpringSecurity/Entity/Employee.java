package com.example.SpringSecurity.Entity;

import com.example.SpringSecurity.appuser.AppUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String address;
    private String phone;
    private boolean isActive;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    /*@JoinColumns({
            @JoinColumn(name="app_user_id", referencedColumnName="id"),
            @JoinColumn(name="manager_id", referencedColumnName="id")
    })*/
    private AppUser appUser;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department department;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "designation_id", referencedColumnName = "id")
    private Department designation;

    public Employee(String name, String address, String phone, boolean isActive, AppUser appUser, Department department, Department designation) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.appUser = appUser;
        this.department = department;
        this.designation = designation;
    }
}
