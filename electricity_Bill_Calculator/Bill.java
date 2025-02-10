package electricity_Bill_Calculator;
abstract interface Bill extends DomesticBill{
	private void printBill(int unit,float charges,float fcaCharges,float duty,float subsidy,float totalCharges,float fixedCharges, String area) {
		System.out.println("|------------------------------------------- Total Bill Charges ------------------------------------------|");
		System.out.println();
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
		System.out.println("|      Charges      |      Rate(in Rs.)      |            Calculation                |       "+area+" Area   |");
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
		System.out.println("|Energy charges*                                                                     |        " +charges+"        |");
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
		System.out.println("|FCA charges*                                                                        |        " +fcaCharges+"         |");
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
		System.out.println("|Duty charges                                                                        |        " +duty+"         |");
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
		System.out.println("|Fixed charges                                                                       |        " +fixedCharges+"         |");
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
		System.out.println("|                            INDIRA GRIH JYOTI YOJNA SUBSIDY*                        |       -" +subsidy +"        |");
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
        System.out.println("|Total Charges**                                                                     |        "+totalCharges+"         |");
		System.out.println("|---------------------------------------------------------------------------------------------------------|");
	}
	
	private void upto30UnitBill(int unit,String area) {
		float Charges =  getElectricityUsageCharges(unit) ;
		float fcaCharges = getFcaCharges(unit) ;
		float duty =Math.round(getTotalDutyCharges(unit));
		float subsidy = ((Charges+fcaCharges+duty)-25);
		float totalCharges = 25f;
		printBill(unit, Charges, fcaCharges, duty, subsidy, totalCharges,0.0f, area);
	}
	private void  upto100UnitBill(int unit,String area) {
		float Charges =  getElectricityUsageCharges(unit) ;
		float fcaCharges = getFcaCharges(unit) ;
		float duty =Math.round(getTotalDutyCharges(unit));
		float subsidy = ((Charges+fcaCharges+duty)-25);
		float fixedCharges=0f;
		if(area.equalsIgnoreCase("Rural")) {
			fixedCharges = getRuralFixedCharges(unit);
		}else {
			fixedCharges = getUrbanFixedCharges(unit);
		}
		float totalCharges = 25f;
		printBill(unit, Charges, fcaCharges, duty, subsidy, totalCharges,fixedCharges, area);
	}
	default void calculate(int unit,String area) {
		upto30UnitBill(unit, area);
	}
}