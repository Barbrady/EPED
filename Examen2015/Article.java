import Biblioteca.Listas.*;

public class Article implements ArticleIF {
	
	private String content;
	private String section;
	private ListIF<String> tags;
	
	public Article() {
		
		content = null;
		section = null;
		tags = new ListDynamic<String>();
	}
	
	public Article (String c, String s, ListIF<String> t) {
		
		this();
		content = c;
		section = s;
		tags = t;
	}

	@Override
	public String getContent() {
		
		return content;
	}

	@Override
	public ListIF<String> getTags() {
		
		return tags;
	}

	@Override
	public String getSection() {
		
		return section;
	}

}