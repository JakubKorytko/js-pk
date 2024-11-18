package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Color red = new Color(255, 0, 0, 255);
        Triangle redTriangle =  new  Triangle(5, 10,  5, red);
        redTriangle.print();
        System.out.println(redTriangle.getColorDescription());
    }
}