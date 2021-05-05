package com.example.productionprojectfinal;

public class UserHelperClass {


    String fnames, lnames, emails, instituitions, passwords;

    public String getFnames() {
        return fnames;
    }

    public void setFnames(String fnames) {
        this.fnames = fnames;
    }

    public String getLnames() {
        return lnames;
    }

    public void setLnames(String lnames) {
        this.lnames = lnames;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getInstituitions() {
        return instituitions;
    }

    public void setInstituitions(String instituitions) {
        this.instituitions = instituitions;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public UserHelperClass() {
    }

    public UserHelperClass(String fnames, String lnames, String emails, String instituitions, String passwords) {
        this.fnames = fnames;
        this.lnames = lnames;
        this.emails = emails;
        this.instituitions = instituitions;
        this.passwords = passwords;
    }


}
