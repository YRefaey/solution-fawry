import java.util.*;
public class car { 
    public static void main(String[] args) {
public class car {
	
		Engine engine;
		setEngine(Engine engine) {
			this.engine = engine;
		}
		start() {
			engine.start();
		}
		stop() {
			engine.stop();
		}
		accelerate() {
			if (this.speed < 200)
				this.speed += 20;
		}
		brake() {
			if (this.speed > 0)
				this.speed -= 20;
		}
	 
	}
	 
	interface Engine {
		start();
		stop();
		setSpeed(int speed);
	}
	 
	class HybridEngine {
	 
		GasEngine gasEngine;
		ElectricEngine electricEngine;
		operatingEngine;
		start() {
			operatingEngine = electricEngine;
			electricEngine.start();
		}
		setSpeed(int speed) {
			if (speed > 50 && this.speed < 50) {
				gasEngine.start();
				electicEngine.stop();
				operatingEngine = gasEngine;
			} else if (speed < 50 && this.speed > 50) {
				operatingEning = electicEngine;
				electicEngine.start();
				electicEngine.setSpeed(speed);
				gasEngine.stop();
			}
			this.speed = speed;
			operatingEngine.setSpeed(speed);
		}
		stop() {
			operatingEngine.stop();
		}
	}
	 
	enum EngineType {GAS, ELECTRIC, HYBRID}
	 
	CarFactory {
		static createCar(EngineType type) {
			Car car = new Car();
			installEngine(car, type);
			return car;
		}
		private static createEngine(EngineType type) {
			case GAS: return new GasEngine();
			case ELECTRIC: return new ElectricEngine();
			case HYBRID: return new HybridEngine();
		}
		static installEngine(Car car, EngineType type) {
			car.setEngine(createEngine(type));
		}
	}

}
