package adapter;

public class LogicAdapter {

	public static void main(String[] args) {
	
		LogicAdapter obj  = new LogicAdapter();
		IExistingLogic existingLogic = new ExistingLogic();
		String input = "sita ram";
		obj.transoform(input, existingLogic);
		
		INewLogic newLogic = new NewLogic();
		NewLogicAdapter newLogicAdapter = new NewLogicAdapter(newLogic);
		obj.transoform(input, newLogicAdapter);
	}
	
	public void transoform(String input, IExistingLogic worker) {
		String output = worker.manipulate(input);
		System.out.println("input: "+input+" output: "+output);
	}
	
}

interface IExistingLogic{
	public String manipulate(String input);
}

class ExistingLogic implements IExistingLogic{

	@Override
	public String manipulate(String input) {

		return input.toUpperCase();
	}
	
}


//new apis provide by ome sdk library provider, 
//we can not modify these clases as they are wrappedn in jar

interface INewLogic{
	public String manipulate(String input);
}

class NewLogic implements INewLogic{

	@Override
	public String manipulate(String input) {

		return input.toLowerCase();
	}
	
}

class NewLogicAdapter implements IExistingLogic{

	private INewLogic newLogic;
	
	
	public NewLogicAdapter(INewLogic newLogic) {
		this.newLogic = newLogic;
	}


	@Override
	public String manipulate(String input) {
		return newLogic.manipulate(input);
	}
	
}