package com.goznauk.skills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by goznauk on 2014. 7. 23..
 */
public class Skill {
    protected int level;
    protected String name;

    public Skill(int level) {
        this.level = level;
        loadProperties(level);
    }

    protected void loadProperties(int level) {
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream("skillset.xml"));
            name = (String)properties.get("level" + level);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void use() { }
}
