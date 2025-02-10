package electricity_Bill_Calculator;

abstract interface DomesticBill {
	private float energyCharges(int unit) {
		if(unit<=30) return 3.34f;
		if(unit<=150) return 5.17f;
		if(unit<=300) return 6.55f;
		return 6.74f;
	}

	private float slabWiseCalculation(int unit) {
		if(unit<=12) return 45.0f;
		return energyCharges(unit) * unit;
	}
	default float getElectricityUsageCharges(int unit) {
		return slabWiseCalculation(unit);
	}
	private float fcaCharges(int unit) {
		if(unit<=12) return 0.0f;
		return unit * 0.34f;
	}
	default float getFcaCharges(int unit) {
		return fcaCharges(unit);
	}
	private float dutyChargeRate(int unit) {
		if(unit<=50) return 0.09f;
		return 0.12f;
	}
	private float slabWiseDuty(int unit) {
		return unit*energyCharges(unit)*dutyChargeRate(unit);
	}
	private float FCAOnDuty(int unit) {
		return unit*dutyChargeRate(unit)*0.34f;
	}
	default float getTotalDutyCharges(int unit) {
		return slabWiseDuty(unit)+FCAOnDuty(unit);
	}
	
	
	private float urbanAreaSubsidy(int unit) {
		
		if(unit>150) return 0.0f;
		return unit * 5.69f;
	}
	
	private float ruralAreaSubsidy(int unit) {
		if(unit>150) return 0.0f;
		return unit * 5.46f;
	}
	private int each15UnitPart(int unit) {
		int parts=0;
		while(unit!=0) {
			if(unit<15) {
				parts++;
				break;
			}
			unit/=15;
			parts++;
		}
		return parts;
	}
	private int urban(int unit) {
		if (unit<=50) return 69;
		if(unit<=150) return 121;
		if(unit<=300) return each15UnitPart(unit)*26;
		return each15UnitPart(unit)*27;
	}
	private int rural(int unit) {
		if (unit<=50) return 55;
		if(unit<=150) return 98;
		if(unit<=300) return each15UnitPart(unit)* 23;
		return each15UnitPart(unit) * 26;
	}
	default int getUrbanFixedCharges(int unit) {
		return urban(unit);
	}
	default int getRuralFixedCharges(int unit) {
		return rural(unit);
	}
}
