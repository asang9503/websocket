package com.yyx.studentad.pojo;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class School {
    private Integer schoolId;

    @NotEmpty
    private String schoolNumber;

    @NotEmpty
    private String schoolName;

    @NotEmpty
    private String schoolAddress;

    @NotEmpty
    @Size(max = 11, min = 11)
    private String schoolTell;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber == null ? null : schoolNumber.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress == null ? null : schoolAddress.trim();
    }

    public String getSchoolTell() {
        return schoolTell;
    }

    public void setSchoolTell(String schoolTell) {
        this.schoolTell = schoolTell == null ? null : schoolTell.trim();
    }
}