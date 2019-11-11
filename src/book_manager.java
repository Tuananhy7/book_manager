package pack_01;

import pack_01.*;
//import gói thư viện java.util.LinkedList
import java.util.LinkedList;
// package nhập stdin
import java.util.Scanner;

// package write data
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// package read data
import java.io.BufferedReader;
import java.io.FileReader;

import java.lang.String;

public class book_manager
{
    //static LinkedList<book> linked = new LinkedList<>();
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean run_program = true;
        display screen = new display();
        while(run_program)
        {
            //screen.clearConsole();
            screen.init_display();
            int feature = input.nextInt();
            switch(feature)
            {
                case 1: add_book(); break;
                case 2: delete_book(); break;
                case 3: search_book(); break;
                case 4: list_book(); break;
                default:
                {
                    System.out.println("try again");
                    break;
                }
            }
        }
        input.close();
    }

    private static void add_book()
    {
        Scanner input = new Scanner(System.in);
        String frame_write = "empty";
        book book_in_store = new book("0", "empty", "empty");
        rm_file manager_file = new rm_file();

        System.out.println("enter id of book");
        book_in_store.setId(input.nextLine());
        System.out.println("title");
        book_in_store.setTitle(input.nextLine());
        System.out.println("author");
        book_in_store.setAuthor(input.nextLine());
        //write to datafile
        frame_write = book_in_store.getId() + "||" + book_in_store.getTitle() + "||" + book_in_store.getAuthor();
        manager_file.write_dara(frame_write);

        System.out.println("add book successfull");
    }

    private static void delete_book()
    {
        Scanner input = new Scanner(System.in);
        display screen = new display();
        screen.delete_display();

        int temp = input.nextInt();
        if(temp == 1)
        {
            Scanner input_02 = new Scanner(System.in);
            System.out.println("enter ID");
            String temp_string = input_02.nextLine();
            /* xóa theo ID */
            try
            {
                File f = new File("datafile.txt");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null)
                {
                    if(line.equals("BOOK STORE")) {continue;}
                    System.out.println(line.substring(0, line.indexOf("||")).equals(temp_string));
                }

                fr.close();
                br.close();
            } 
            catch (IOException ex) 
            {
                 System.out.println("Loi doc file: " + ex);
            }
        }
        else if(temp == 2)
        {
            /*xóa theo title*/

        }else {System.out.println("try again");}

    }

    private static void search_book()
    {
        Scanner input = new Scanner(System.in);
        display screen = new display();
        screen.search_display();

        int temp = input.nextInt();
        if(temp == 1)
        {
            Scanner input_02 = new Scanner(System.in);
            System.out.println("enter ID");
            String temp_string = input_02.nextLine();
            /* tìm theo ID */
            try
            {
                File f = new File("datafile.txt");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null)
                {
                    if(line.equals("BOOK STORE")) {continue;}
                    if(line.substring(0, line.indexOf("||")).equals(temp_string) == true)
                    {
                        break;
                    }
                }
                
                System.out.println(line);
                fr.close();
                br.close();
            } 
            catch (IOException ex) 
            {
                 System.out.println("Loi doc file: " + ex);
            }
        }
        else if(temp == 2)
        {
            /*tìm theo title*/
            Scanner input_02 = new Scanner(System.in);
            System.out.println("enter TITLE");
            String temp_string = input_02.nextLine();
            /* xóa theo ID */
            try
            {
                File f = new File("datafile.txt");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null)
                {
                    if(line.equals("BOOK STORE")) {continue;}
                    if(line.substring(0, line.indexOf("||", line.indexOf("||"))).equals(temp_string) == true)
                    {
                        break;
                    }
                }
                
                System.out.println(line);
                fr.close();
                br.close();
            } 
            catch (IOException ex) 
            {
                 System.out.println("Loi doc file: " + ex);
            }

        }else {System.out.println("try again");}
    }

    private static void list_book()
    {
        rm_file list_file = new rm_file();
        list_file.read_data();
    }

}


