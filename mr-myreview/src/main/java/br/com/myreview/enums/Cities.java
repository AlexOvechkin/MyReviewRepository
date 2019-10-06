package br.com.myreview.enums;

public enum Cities {
	SAO_JOSE("São José", States.SC),
	FLORIANOPOLIS("Florianopolis", States.SC),
	PALHOCA("Palhoça", States.SC),
	PELOTAS("Pelotas", States.RS),
	GRAMADO("Gramado", States.RS),
	CAXIAS_DO_SUL("Caxias do sul", States.RS);
	
	
	private final String name;
	private final States states;
	
	private Cities(String name, States state) {
		this.name = name;
		this.states = state;
	}

	public String getName() {
		return name;
	}

	public States getStates() {
		return states;
	}
	
	
}
