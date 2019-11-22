package com.huidian.domain;


import javax.persistence.*;

@Entity
@Table(name = "stu")
public class Stu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sno;
    @Column
    private String sname;
    @Column
    private int sage;

    public Stu() {
    }

    public Stu(String sname, int sage) {
        this.sname = sname;
        this.sage = sage;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                '}';
    }
}
