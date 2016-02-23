package hudson.plugins.starwars.quotes;

import hudson.plugins.starwars.StarWarsResult;

public class Quote {

	private String quote;
	private QuoteAuthor author;
	private StarWarsResult result;

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public QuoteAuthor getAuthor() {
		return author;
	}

	public void setAuthor(QuoteAuthor author) {
		this.author = author;
	}

	public StarWarsResult getResult() {
		return result;
	}

	public void setResult(StarWarsResult result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((quote == null) ? 0 : quote.hashCode());
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (author != other.author)
			return false;
		if (quote == null) {
			if (other.quote != null)
				return false;
		} else if (!quote.equals(other.quote))
			return false;
		if (result != other.result)
			return false;
		return true;
	}

}
