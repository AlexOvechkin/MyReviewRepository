package br.com.myreview.enums;

public enum Districts {
	FORQUILHAS("Forquilhas", Cities.SAO_JOSE),
	KOBRASOL("Kobrasol", Cities.SAO_JOSE),
	ESTREITO("Estreito", Cities.SAO_JOSE),
	BREJARU("Brejaru", Cities.PALHOCA),
	PACHECO("Pacheco", Cities.PALHOCA),
	RIBEIRAO_DA_ILHA("Ribeirao da Ilha", Cities.FLORIANOPOLIS),
	CAMPECHE("Campeche", Cities.FLORIANOPOLIS),
	MATO_QUEIMADO("Mato Queimado", Cities.GRAMADO),
	BAVÁRIA("Bavária", Cities.GRAMADO),
	FRAGATA("Fragata", Cities.PELOTAS),
	ARCO_IRIS("Arco-Íris", Cities.PELOTAS),
	NAVEGANTES_II("Naveganes II", Cities.PELOTAS),
	PLANALTO("Fragata", Cities.CAXIAS_DO_SUL),
	CHARQUEADAS("Charqueadas", Cities.CAXIAS_DO_SUL),
	CRUZEIRO("Cruzeiro", Cities.CAXIAS_DO_SUL);
	
	
	
	private final String name;
	private final Cities cities;
	
	private Districts(String name, Cities city) {
		this.name = name;
		this.cities = city;
	}

	public String getName() {
		return name;
	}

	public Cities getCities() {
		return cities;
	}
}
