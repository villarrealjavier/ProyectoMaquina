package main.java.model;

public enum Moneda {
	FIVECENT(5),
	TENCENT(10),
	TWENTYCENT(20),
	FITTYCENT(50),
	ONEEURO(100),
	TWOEURO(200);

	int value;
	Moneda(int valor) {
		this.value=valor;
	}
}
