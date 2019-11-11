package pack_01;

// package write data
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// package read data
import java.io.BufferedReader;
import java.io.FileReader;

class book
{
    private String id;
    private String title;
    private String author;

    // constructor
    book(String id_init, String title_init, String author_init)
    {
        id=id_init;
        title=title_init;
        author=author_init;
    }

    //getter
    public String getId() {return id;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}

    //setter
    public void setId(String vid) {this.id = vid;}
    public void setTitle(String vtitle) {this.title = vtitle;}
    public void setAuthor(String vauthor) {this.author = vauthor;}
}

class rm_file
{
    public void read_data()
    {
        try
        {
            File f = new File("datafile.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null){
            System.out.println(line);
            }

            fr.close();
            br.close();
        } 
        catch (IOException ex) 
        {
            System.out.println("Loi doc file: " + ex);
        }
        System.out.println("LIST DONE");
    }

    public void write_dara(String temp)
    {
        try
        {
            File f = new File("datafile.txt");
            FileWriter fw = new FileWriter(f, true);
            fw.write(temp);
            fw.write("\n");
            fw.close();
        } 
        catch (IOException ex) 
        {
            System.out.println("Loi ghi file: " + ex);
        }
    }
}

class display
{
    String feature_01 = "01. add book";
    String feature_02 = "02. delete book";
    String feature_03 = "03. search book";
    String feature_04 = "04. list book";

    public void init_display()
    {
        System.out.println("select feature:");
        System.out.println(feature_01);
        System.out.println(feature_02);
        System.out.println(feature_03);
        System.out.println(feature_04);
    }

    public void delete_display()
    {
        System.out.println("select feature DELETE:");
        System.out.println("01. type 'ID' must delete");
        System.out.println("02. type 'TITLE' must delete");
    }

    public void search_display()
    {
        System.out.println("select feature SEARCH:");
        System.out.println("01. type 'ID'");
        System.out.println("02. type 'TITLE'");
    }

    public final void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
            System.out.println("ngoai le roi ong giao oi");
        }
    }
}