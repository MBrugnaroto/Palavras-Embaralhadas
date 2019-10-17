package MecanicasDoJogo;
import Principal.MecanicaDoJogo;

public class Acertou implements MecanicaDoJogo {
	private int pontuação;
	
	public Acertou() {
		pontuação = 0;
	}
	
	@Override
	public String funcaoMecanica() {
		pontuação += 5;
		
		return "Acertou";
	}
	
	public int getPontuação() {
		return pontuação;
	}
	
}
