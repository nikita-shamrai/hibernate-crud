package org.example.controller;

import org.example.repository.InitializeDBImpl;

public class App 
{
    public static void main( String[] args )
    {
        new InitializeDBImpl().createAndFillTable();
        new Controller().startController();
    }

}
