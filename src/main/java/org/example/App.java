package org.example;

import org.example.dao.PersonDaoImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println(new PersonDaoImpl().findById(3L));
    }
}
