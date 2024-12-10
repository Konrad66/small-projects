package org.example.kodi.module1.submodule5;

public class Application {

    public static void main(String args[]) {

        FixedSalaryEmployee employee = new FixedSalaryEmployee(2000.0);

        ProductSalaryEmployee employee1 = new ProductSalaryEmployee(5, 10);
        boolean employeeSoldAdditionalProduct = true;
        SpecialSalaryEmployee employee2 = new SpecialSalaryEmployee(employeeSoldAdditionalProduct);

        SalaryPayoutProcessor processorForEmployee1 = new SalaryPayoutProcessor(employee1);
        SalaryPayoutProcessor processorForEmployee2 = new SalaryPayoutProcessor(employee2);
        SalaryPayoutProcessor processor = new SalaryPayoutProcessor(employee);
        processor.processPayout();
        processorForEmployee1.processPayout();
        processorForEmployee2.processPayout();
    }
}
