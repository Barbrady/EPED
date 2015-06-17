
/**
 * Write a description of class ArticuloIndex here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArticuloIndex
{
    // instance variables - replace the example below with your own
    private int index;
    private String content;
    private String section;
    /**
     * Constructor for objects of class ArticuloIndex
     */
    public ArticuloIndex()
    {
        index = -1;
        content = null;
        section = null;
    }
    
    public ArticuloIndex(String content, String section, int index)  
    {
        this.index = index;
        this.content = content;
        this.section = section;
    }
    
    public int getIndex()  
    {
        return index;
    }
    
    public String getContent ()
    {
        return content;
    }
    
    public String getSection ()
    {
        return section;
    }

}
