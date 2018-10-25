package com.oksana.entities;

import org.springframework.stereotype.Component;

@Component
public class MyContacts {
    private String aboutMe;
    private String impressum;
    private String datenschutz;

    public String getDatenschutz() {
        return datenschutz;
    }

    public void setDatenschutz(String datenschutz) {
        this.datenschutz = datenschutz;
    }

    public String getImpressum() {
        return impressum;
    }

    public void setImpressum(String impressum) {
        this.impressum = impressum;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
}
