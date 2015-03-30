package menucreate;

import abstractinterfaces.Generator;

public class GeneratorFactory {

	public Generator createGenerator(String type)
	{
		if(type.equalsIgnoreCase("Diner"))
			return new DinerGenerator();
		else if(type.equalsIgnoreCase("Evening"))
			return new EveningGenerator();
		else
			return new AllGenerator();
	}
	
	public Food generator(Generator g, Food f)
	{
		Food f2=g.generate(f);
		return f2;
	}
}
