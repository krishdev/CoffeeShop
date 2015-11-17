package midterm;

public class Quotes {

	private int NoQuote;
	private String QuoteAuthor;
	private String Quote;
	private int count=0;
	
	
	public Quotes(int NoQuote,String QuoteAuthor, String Quote){
		this.NoQuote=NoQuote;
		this.QuoteAuthor = QuoteAuthor;
		this.Quote = Quote;
		
	}

	public int getcount()
	{
		return count;
	}
	public int getQuoteId() {
		return NoQuote;
	}

	public void setQuoteId(int NoQuote) {
		this.NoQuote = NoQuote;
	}

	public String getAuthor() {
		return QuoteAuthor;
	}

	public void setAuthor(String QuoteAuthor) {
		this.QuoteAuthor = QuoteAuthor;
	}

	public String getQuote() {
		return Quote;
	}

	public void setQuote(String Quote) {
		this.Quote = Quote;
	}

	
}