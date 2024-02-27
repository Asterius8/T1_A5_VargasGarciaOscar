
public class ConversorTemperatura {

	public double caF(double c) {
		return ( ( 1.8 * c ) + 32 );
	}
	
	public double caK(double c) {
		return (c + 273.15);
	}
	
	public double caR(double c) {
		return (  ( 1.8 * c ) + 491.67 );
	}
	
	public double faC(double f) {
		return ( ( f - 32 ) / 1.8 );
	}

	public double faK(double f) {
		return ( ( f + 459.67 ) / 1.8 );
	}
	
	public double faR(double f) {
		return ( f + 459.67 );
	}
	
	public double kaC(double k) {
		return ( k - 273.15 );
	}
	
	public double kaF(double k) {
		return ( ( 1.8 * k )  - 459.67 ) ;
	}
	
	public double kaR(double k) {
		return ( k * 1.8 );
	}
	
	public double raC(double r) {
		return ( ( ( r - 32 ) - 459.67 ) / 1.8 );
	}
	
	public double raF(double r) {
		return ( r - 459.67 );
	}
	
	public double raK(double r) {
		return ( r / 1.8 );
	}
	
	
}
