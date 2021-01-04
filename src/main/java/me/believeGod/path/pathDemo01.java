package me.believeGod.path;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author LTJ
 * @version 1.0
 * @date 2020/12/11 10:19
 */
public class pathDemo01 {


    @Test
    public void testPath() throws IOException {
        String property = System.getProperty("user.dir");
        System.out.println("property = " + property);
        URL resource = this.getClass().getResource("");
        String path = resource.getPath();
        System.out.println("path = " + path);


        Enumeration<URL> resources = this.getClass().getClassLoader().getResources("");
        while(resources.hasMoreElements()){
            String path1 = resources.nextElement().getPath();
            System.out.println("path1 = " + path1);
        }

    }
}
